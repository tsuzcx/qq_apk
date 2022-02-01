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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements b.a
{
  private MMClearEditText fwS;
  private TextView fwT;
  private Button fwU;
  private TextView fwV;
  private ScrollView fwW;
  private InputPanelLinearLayout fwX;
  private String fwY;
  private String fwZ;
  private String roomId;
  private int scene;
  private TextView titleView;
  
  private void sg(String paramString)
  {
    AppMethodBeat.i(197136);
    if (bs.isNullOrNil(paramString))
    {
      this.fwV.setVisibility(8);
      AppMethodBeat.o(197136);
      return;
    }
    this.fwV.setVisibility(0);
    this.fwV.setText(paramString);
    AppMethodBeat.o(197136);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(197135);
    ac.i("MicroMsg.RemarkRoomNameUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.fwU.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.fwU.setLayoutParams(localLayoutParams);
      this.fwX.setPadding(this.fwX.getPaddingLeft(), this.fwX.getPaddingTop(), this.fwX.getPaddingRight(), paramInt);
      paramInt = this.fwW.getHeight();
      this.fwX.requestLayout();
      this.fwX.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197130);
          ac.i("MicroMsg.RemarkRoomNameUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() > paramInt) {
            ModRemarkRoomNameUI.f(ModRemarkRoomNameUI.this).scrollBy(0, ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(197130);
        }
      });
      AppMethodBeat.o(197135);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.fwU.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.fwU.setLayoutParams(localLayoutParams);
    this.fwX.setPadding(this.fwX.getPaddingLeft(), this.fwX.getPaddingTop(), this.fwX.getPaddingRight(), 0);
    this.fwW.scrollBy(0, 0);
    AppMethodBeat.o(197135);
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
    this.fwW = ((ScrollView)findViewById(2131304376));
    this.fwX = ((InputPanelLinearLayout)findViewById(2131301024));
    this.fwX.setExternalListener(this);
    this.fwS = ((MMClearEditText)findViewById(2131302434));
    this.titleView = ((TextView)findViewById(2131302436));
    this.fwT = ((TextView)findViewById(2131302435));
    this.fwU = ((Button)findViewById(2131302852));
    this.fwV = ((TextView)findViewById(2131299523));
    Object localObject2 = (ImageView)findViewById(2131297960);
    Object localObject3 = findViewById(2131297969);
    this.scene = getIntent().getIntExtra("Key_Scenen", 0);
    this.roomId = getIntent().getStringExtra("Key_Room_Id");
    ac.i("MicroMsg.RemarkRoomNameUI", "scene %d, roomId %s", new Object[] { Integer.valueOf(this.scene), this.roomId });
    if (bs.isNullOrNil(this.roomId)) {
      finish();
    }
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
    if ((int)((b)localObject1).fLJ > 0) {
      com.tencent.mm.ui.f.a.a.c((ImageView)localObject2, ((av)localObject1).field_username);
    }
    localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(this, bs.nullAsNil(((av)localObject1).field_nickname));
    localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(this, bs.nullAsNil(((av)localObject1).field_conRemark));
    ac.i("MicroMsg.RemarkRoomNameUI", "roomName %s, remarkName %s", new Object[] { localObject2, localObject1 });
    switch (this.scene)
    {
    default: 
      ac.w("MicroMsg.RemarkRoomNameUI", "unknown scene %d, finish()", new Object[] { Integer.valueOf(this.scene) });
      finish();
    case 1: 
    case 3: 
      for (;;)
      {
        this.fwS.setSelection(this.fwS.getText().length());
        this.fwS.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(197128);
            ModRemarkRoomNameUI.c(ModRemarkRoomNameUI.this).setEnabled(ModRemarkRoomNameUI.b(ModRemarkRoomNameUI.this));
            AppMethodBeat.o(197128);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(197127);
            if (paramAnonymousCharSequence.length() > 0)
            {
              ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(null);
              AppMethodBeat.o(197127);
              return;
            }
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(TextUtils.TruncateAt.END);
            AppMethodBeat.o(197127);
          }
        });
        localObject1 = com.tencent.mm.ui.tools.b.c.d(this.fwS).acw(32);
        ((com.tencent.mm.ui.tools.b.c)localObject1).IVj = false;
        ((com.tencent.mm.ui.tools.b.c)localObject1).a(null);
        this.fwS.requestFocus();
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
        this.fwU.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(197129);
            ModRemarkRoomNameUI.d(ModRemarkRoomNameUI.this);
            AppMethodBeat.o(197129);
          }
        });
        AppMethodBeat.o(12668);
        return;
        this.titleView.setText(2131762577);
        this.fwT.setText(2131761317);
        this.fwS.setText((CharSequence)localObject2);
        if (bs.aj((CharSequence)localObject2)) {
          this.fwS.setHint(getString(2131762622));
        }
        this.fwZ = getString(2131762586);
        this.fwY = getString(2131762588);
        continue;
        this.titleView.setText(2131762651);
        this.fwT.setText(2131761315);
        localObject3 = this.fwS;
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = ((x)localObject2).field_selfDisplayName;
        }
        localObject2 = localObject1;
        if (bs.isNullOrNil((String)localObject1)) {
          localObject2 = u.axy();
        }
        ((MMClearEditText)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject2)));
        this.fwZ = getString(2131762587);
        this.fwY = getString(2131762585);
      }
    }
    this.titleView.setText(2131762676);
    this.fwT.setText(2131761318);
    this.fwS.setText((CharSequence)localObject1);
    this.fwS.setHint(2131762676);
    if (bs.aj((CharSequence)localObject2)) {}
    for (localObject1 = getString(2131762622);; localObject1 = localObject2)
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)findViewById(2131297970)).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, getString(2131761316, new Object[] { localObject1 })));
      localObject1 = (TextView)findViewById(2131297971);
      if (!bs.aj((CharSequence)localObject2)) {
        ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(197126);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setText(this.fxa);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setSelection(ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).getText().length());
            this.fxb.setVisibility(8);
            AppMethodBeat.o(197126);
          }
        });
      }
      for (;;)
      {
        this.fwZ = getString(2131763304);
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