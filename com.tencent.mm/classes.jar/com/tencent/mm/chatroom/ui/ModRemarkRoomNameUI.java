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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements b.a
{
  private MMClearEditText fSl;
  private TextView fSm;
  private Button fSn;
  private TextView fSo;
  private ScrollView fSp;
  private InputPanelLinearLayout fSq;
  private String fSr;
  private String fSs;
  private String roomId;
  private int scene;
  private TextView titleView;
  
  private void vr(String paramString)
  {
    AppMethodBeat.i(217260);
    if (bu.isNullOrNil(paramString))
    {
      this.fSo.setVisibility(8);
      AppMethodBeat.o(217260);
      return;
    }
    this.fSo.setVisibility(0);
    this.fSo.setText(paramString);
    AppMethodBeat.o(217260);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(217259);
    ae.i("MicroMsg.RemarkRoomNameUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.fSn.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.fSn.setLayoutParams(localLayoutParams);
      this.fSq.setPadding(this.fSq.getPaddingLeft(), this.fSq.getPaddingTop(), this.fSq.getPaddingRight(), paramInt);
      paramInt = this.fSp.getHeight();
      this.fSq.requestLayout();
      this.fSq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217254);
          ae.i("MicroMsg.RemarkRoomNameUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() > paramInt) {
            ModRemarkRoomNameUI.f(ModRemarkRoomNameUI.this).scrollBy(0, ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(217254);
        }
      });
      AppMethodBeat.o(217259);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.fSn.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.fSn.setLayoutParams(localLayoutParams);
    this.fSq.setPadding(this.fSq.getPaddingLeft(), this.fSq.getPaddingTop(), this.fSq.getPaddingRight(), 0);
    this.fSp.scrollBy(0, 0);
    AppMethodBeat.o(217259);
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
    this.fSp = ((ScrollView)findViewById(2131304376));
    this.fSq = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fSq.setExternalListener(this);
    this.fSl = ((MMClearEditText)findViewById(2131302434));
    this.titleView = ((TextView)findViewById(2131302436));
    this.fSm = ((TextView)findViewById(2131302435));
    this.fSn = ((Button)findViewById(2131302852));
    this.fSo = ((TextView)findViewById(2131299523));
    Object localObject2 = (ImageView)findViewById(2131297960);
    Object localObject3 = findViewById(2131297969);
    this.scene = getIntent().getIntExtra("Key_Scenen", 0);
    this.roomId = getIntent().getStringExtra("Key_Room_Id");
    ae.i("MicroMsg.RemarkRoomNameUI", "scene %d, roomId %s", new Object[] { Integer.valueOf(this.scene), this.roomId });
    if (bu.isNullOrNil(this.roomId)) {
      finish();
    }
    Object localObject1 = ((l)g.ab(l.class)).azF().BH(this.roomId);
    if ((int)((com.tencent.mm.contact.c)localObject1).ght > 0) {
      com.tencent.mm.ui.f.a.a.c((ImageView)localObject2, ((aw)localObject1).field_username);
    }
    localObject2 = k.c(this, bu.nullAsNil(((aw)localObject1).field_nickname));
    localObject1 = k.c(this, bu.nullAsNil(((aw)localObject1).field_conRemark));
    ae.i("MicroMsg.RemarkRoomNameUI", "roomName %s, remarkName %s", new Object[] { localObject2, localObject1 });
    switch (this.scene)
    {
    default: 
      ae.w("MicroMsg.RemarkRoomNameUI", "unknown scene %d, finish()", new Object[] { Integer.valueOf(this.scene) });
      finish();
    case 1: 
    case 3: 
      for (;;)
      {
        this.fSl.setSelection(this.fSl.getText().length());
        this.fSl.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(217252);
            ModRemarkRoomNameUI.c(ModRemarkRoomNameUI.this).setEnabled(ModRemarkRoomNameUI.b(ModRemarkRoomNameUI.this));
            AppMethodBeat.o(217252);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(217251);
            if (paramAnonymousCharSequence.length() > 0)
            {
              ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(null);
              AppMethodBeat.o(217251);
              return;
            }
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(TextUtils.TruncateAt.END);
            AppMethodBeat.o(217251);
          }
        });
        localObject1 = com.tencent.mm.ui.tools.b.c.d(this.fSl).afD(32);
        ((com.tencent.mm.ui.tools.b.c)localObject1).LiL = false;
        ((com.tencent.mm.ui.tools.b.c)localObject1).a(null);
        this.fSl.requestFocus();
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
        this.fSn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(217253);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ModRemarkRoomNameUI.d(ModRemarkRoomNameUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(217253);
          }
        });
        AppMethodBeat.o(12668);
        return;
        this.titleView.setText(2131762577);
        this.fSm.setText(2131761317);
        this.fSl.setText((CharSequence)localObject2);
        if (bu.ah((CharSequence)localObject2)) {
          this.fSl.setHint(getString(2131762622));
        }
        this.fSs = getString(2131762586);
        this.fSr = getString(2131762588);
        continue;
        this.titleView.setText(2131762651);
        this.fSm.setText(2131761315);
        localObject3 = this.fSl;
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = ((ac)localObject2).field_selfDisplayName;
        }
        localObject2 = localObject1;
        if (bu.isNullOrNil((String)localObject1)) {
          localObject2 = v.aAE();
        }
        ((MMClearEditText)localObject3).setText(k.c(this, k.c(this, (CharSequence)localObject2)));
        this.fSs = getString(2131762587);
        this.fSr = getString(2131762585);
      }
    }
    this.titleView.setText(2131762676);
    this.fSm.setText(2131761318);
    this.fSl.setText((CharSequence)localObject1);
    this.fSl.setHint(2131762676);
    if (bu.ah((CharSequence)localObject2)) {}
    for (localObject1 = getString(2131762622);; localObject1 = localObject2)
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)findViewById(2131297970)).setText(k.c(this, getString(2131761316, new Object[] { localObject1 })));
      localObject1 = (TextView)findViewById(2131297971);
      if (!bu.ah((CharSequence)localObject2)) {
        ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(217250);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setText(this.fSt);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setSelection(ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).getText().length());
            this.fSu.setVisibility(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(217250);
          }
        });
      }
      for (;;)
      {
        this.fSs = getString(2131763304);
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