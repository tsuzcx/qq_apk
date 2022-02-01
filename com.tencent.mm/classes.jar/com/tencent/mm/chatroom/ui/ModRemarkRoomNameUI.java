package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements b.a
{
  private MMClearEditText fQf;
  private TextView fQg;
  private Button fQh;
  private TextView fQi;
  private ScrollView fQj;
  private InputPanelLinearLayout fQk;
  private String fQl;
  private String fQm;
  private String roomId;
  private int scene;
  private TextView titleView;
  
  private void uV(String paramString)
  {
    AppMethodBeat.i(213543);
    if (bt.isNullOrNil(paramString))
    {
      this.fQi.setVisibility(8);
      AppMethodBeat.o(213543);
      return;
    }
    this.fQi.setVisibility(0);
    this.fQi.setText(paramString);
    AppMethodBeat.o(213543);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(213542);
    ad.i("MicroMsg.RemarkRoomNameUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.fQh.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.fQh.setLayoutParams(localLayoutParams);
      this.fQk.setPadding(this.fQk.getPaddingLeft(), this.fQk.getPaddingTop(), this.fQk.getPaddingRight(), paramInt);
      paramInt = this.fQj.getHeight();
      this.fQk.requestLayout();
      this.fQk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213537);
          ad.i("MicroMsg.RemarkRoomNameUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() > paramInt) {
            ModRemarkRoomNameUI.f(ModRemarkRoomNameUI.this).scrollBy(0, ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(213537);
        }
      });
      AppMethodBeat.o(213542);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.fQh.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.fQh.setLayoutParams(localLayoutParams);
    this.fQk.setPadding(this.fQk.getPaddingLeft(), this.fQk.getPaddingTop(), this.fQk.getPaddingRight(), 0);
    this.fQj.scrollBy(0, 0);
    AppMethodBeat.o(213542);
  }
  
  public int getLayoutId()
  {
    return 2131494939;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12668);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    this.fQj = ((ScrollView)findViewById(2131304376));
    this.fQk = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fQk.setExternalListener(this);
    this.fQf = ((MMClearEditText)findViewById(2131302434));
    this.titleView = ((TextView)findViewById(2131302436));
    this.fQg = ((TextView)findViewById(2131302435));
    this.fQh = ((Button)findViewById(2131302852));
    this.fQi = ((TextView)findViewById(2131299523));
    Object localObject2 = (ImageView)findViewById(2131297960);
    Object localObject3 = findViewById(2131297969);
    this.scene = getIntent().getIntExtra("Key_Scenen", 0);
    this.roomId = getIntent().getStringExtra("Key_Room_Id");
    ad.i("MicroMsg.RemarkRoomNameUI", "scene %d, roomId %s", new Object[] { Integer.valueOf(this.scene), this.roomId });
    if (bt.isNullOrNil(this.roomId)) {
      finish();
    }
    Object localObject1 = ((l)g.ab(l.class)).azp().Bf(this.roomId);
    if ((int)((com.tencent.mm.o.b)localObject1).gfj > 0) {
      com.tencent.mm.ui.f.a.a.c((ImageView)localObject2, ((aw)localObject1).field_username);
    }
    localObject2 = k.c(this, bt.nullAsNil(((aw)localObject1).field_nickname));
    localObject1 = k.c(this, bt.nullAsNil(((aw)localObject1).field_conRemark));
    ad.i("MicroMsg.RemarkRoomNameUI", "roomName %s, remarkName %s", new Object[] { localObject2, localObject1 });
    switch (this.scene)
    {
    default: 
      ad.w("MicroMsg.RemarkRoomNameUI", "unknown scene %d, finish()", new Object[] { Integer.valueOf(this.scene) });
      finish();
    case 1: 
    case 3: 
      for (;;)
      {
        this.fQf.setSelection(this.fQf.getText().length());
        this.fQf.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(213535);
            ModRemarkRoomNameUI.c(ModRemarkRoomNameUI.this).setEnabled(ModRemarkRoomNameUI.b(ModRemarkRoomNameUI.this));
            AppMethodBeat.o(213535);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(213534);
            if (paramAnonymousCharSequence.length() > 0)
            {
              ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(null);
              AppMethodBeat.o(213534);
              return;
            }
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(TextUtils.TruncateAt.END);
            AppMethodBeat.o(213534);
          }
        });
        localObject1 = com.tencent.mm.ui.tools.b.c.d(this.fQf).aeU(32);
        ((com.tencent.mm.ui.tools.b.c)localObject1).KMn = false;
        ((com.tencent.mm.ui.tools.b.c)localObject1).a(null);
        this.fQf.requestFocus();
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(12665);
            ModRemarkRoomNameUI.this.finish();
            AppMethodBeat.o(12665);
            return true;
          }
        });
        this.fQh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213536);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ModRemarkRoomNameUI.d(ModRemarkRoomNameUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213536);
          }
        });
        AppMethodBeat.o(12668);
        return;
        this.titleView.setText(2131762577);
        this.fQg.setText(2131761317);
        this.fQf.setText((CharSequence)localObject2);
        if (bt.ai((CharSequence)localObject2)) {
          this.fQf.setHint(getString(2131762622));
        }
        this.fQm = getString(2131762586);
        this.fQl = getString(2131762588);
        continue;
        this.titleView.setText(2131762651);
        this.fQg.setText(2131761315);
        localObject3 = this.fQf;
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.roomId);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = ((ab)localObject2).field_selfDisplayName;
        }
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject2 = u.aAo();
        }
        ((MMClearEditText)localObject3).setText(k.c(this, k.c(this, (CharSequence)localObject2)));
        this.fQm = getString(2131762587);
        this.fQl = getString(2131762585);
      }
    }
    this.titleView.setText(2131762676);
    this.fQg.setText(2131761318);
    this.fQf.setText((CharSequence)localObject1);
    this.fQf.setHint(2131762676);
    if (bt.ai((CharSequence)localObject2)) {}
    for (localObject1 = getString(2131762622);; localObject1 = localObject2)
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)findViewById(2131297970)).setText(k.c(this, getString(2131761316, new Object[] { localObject1 })));
      localObject1 = (TextView)findViewById(2131297971);
      if (!bt.ai((CharSequence)localObject2)) {
        ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213533);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setText(this.fQn);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setSelection(ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).getText().length());
            this.fQo.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213533);
          }
        });
      }
      for (;;)
      {
        this.fQm = getString(2131763304);
        break;
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12667);
    super.onCreate(paramBundle);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    initView();
    AppMethodBeat.o(12667);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12670);
    super.onDestroy();
    AppMethodBeat.o(12670);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12669);
    super.onPause();
    AppMethodBeat.o(12669);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI
 * JD-Core Version:    0.7.0.1
 */