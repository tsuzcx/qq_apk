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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b.a;

public class ModRemarkRoomNameUI
  extends MMActivity
  implements b.a
{
  private MMClearEditText ftl;
  private TextView ftm;
  private Button ftn;
  private TextView fto;
  private ScrollView ftp;
  private InputPanelLinearLayout ftq;
  private String ftr;
  private String fts;
  private String roomId;
  private int scene;
  private TextView titleView;
  
  private void oU(String paramString)
  {
    AppMethodBeat.i(196652);
    if (bt.isNullOrNil(paramString))
    {
      this.fto.setVisibility(8);
      AppMethodBeat.o(196652);
      return;
    }
    this.fto.setVisibility(0);
    this.fto.setText(paramString);
    AppMethodBeat.o(196652);
  }
  
  public final void g(boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(196651);
    ad.i("MicroMsg.RemarkRoomNameUI", "keyboard show %s, keyboardHeight %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (paramBoolean)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.ftn.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165289);
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131165289);
      this.ftn.setLayoutParams(localLayoutParams);
      this.ftq.setPadding(this.ftq.getPaddingLeft(), this.ftq.getPaddingTop(), this.ftq.getPaddingRight(), paramInt);
      paramInt = this.ftp.getHeight();
      this.ftq.requestLayout();
      this.ftq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196646);
          ad.i("MicroMsg.RemarkRoomNameUI", "inputContainer.height: %d, screenHeight: %d", new Object[] { Integer.valueOf(ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight()), Integer.valueOf(paramInt) });
          if (ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() > paramInt) {
            ModRemarkRoomNameUI.f(ModRemarkRoomNameUI.this).scrollBy(0, ModRemarkRoomNameUI.e(ModRemarkRoomNameUI.this).getHeight() - paramInt);
          }
          AppMethodBeat.o(196646);
        }
      });
      AppMethodBeat.o(196651);
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ftn.getLayoutParams();
    localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131165277);
    localLayoutParams.topMargin = 0;
    this.ftn.setLayoutParams(localLayoutParams);
    this.ftq.setPadding(this.ftq.getPaddingLeft(), this.ftq.getPaddingTop(), this.ftq.getPaddingRight(), 0);
    this.ftp.scrollBy(0, 0);
    AppMethodBeat.o(196651);
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
    this.ftp = ((ScrollView)findViewById(2131304376));
    this.ftq = ((InputPanelLinearLayout)findViewById(2131301024));
    this.ftq.setExternalListener(this);
    this.ftl = ((MMClearEditText)findViewById(2131302434));
    this.titleView = ((TextView)findViewById(2131302436));
    this.ftm = ((TextView)findViewById(2131302435));
    this.ftn = ((Button)findViewById(2131302852));
    this.fto = ((TextView)findViewById(2131299523));
    Object localObject2 = (ImageView)findViewById(2131297960);
    Object localObject3 = findViewById(2131297969);
    this.scene = getIntent().getIntExtra("Key_Scenen", 0);
    this.roomId = getIntent().getStringExtra("Key_Room_Id");
    ad.i("MicroMsg.RemarkRoomNameUI", "scene %d, roomId %s", new Object[] { Integer.valueOf(this.scene), this.roomId });
    if (bt.isNullOrNil(this.roomId)) {
      finish();
    }
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
    if ((int)((b)localObject1).fId > 0) {
      com.tencent.mm.ui.f.a.a.c((ImageView)localObject2, ((au)localObject1).field_username);
    }
    localObject2 = com.tencent.mm.pluginsdk.ui.span.k.c(this, bt.nullAsNil(((au)localObject1).field_nickname));
    localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c(this, bt.nullAsNil(((au)localObject1).field_conRemark));
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
        this.ftl.setSelection(this.ftl.getText().length());
        this.ftl.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable)
          {
            AppMethodBeat.i(196644);
            ModRemarkRoomNameUI.c(ModRemarkRoomNameUI.this).setEnabled(ModRemarkRoomNameUI.b(ModRemarkRoomNameUI.this));
            AppMethodBeat.o(196644);
          }
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(196643);
            if (paramAnonymousCharSequence.length() > 0)
            {
              ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(null);
              AppMethodBeat.o(196643);
              return;
            }
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setEllipsize(TextUtils.TruncateAt.END);
            AppMethodBeat.o(196643);
          }
        });
        localObject1 = com.tencent.mm.ui.tools.b.c.d(this.ftl).aaj(32);
        ((com.tencent.mm.ui.tools.b.c)localObject1).HuM = false;
        ((com.tencent.mm.ui.tools.b.c)localObject1).a(null);
        this.ftl.requestFocus();
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
        this.ftn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196645);
            ModRemarkRoomNameUI.d(ModRemarkRoomNameUI.this);
            AppMethodBeat.o(196645);
          }
        });
        AppMethodBeat.o(12668);
        return;
        this.titleView.setText(2131762577);
        this.ftm.setText(2131761317);
        this.ftl.setText((CharSequence)localObject2);
        if (bt.ai((CharSequence)localObject2)) {
          this.ftl.setHint(getString(2131762622));
        }
        this.fts = getString(2131762586);
        this.ftr = getString(2131762588);
        continue;
        this.titleView.setText(2131762651);
        this.ftm.setText(2131761315);
        localObject3 = this.ftl;
        localObject2 = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
        localObject1 = "";
        if (localObject2 != null) {
          localObject1 = ((w)localObject2).field_selfDisplayName;
        }
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject2 = u.aqI();
        }
        ((MMClearEditText)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject2)));
        this.fts = getString(2131762587);
        this.ftr = getString(2131762585);
      }
    }
    this.titleView.setText(2131762676);
    this.ftm.setText(2131761318);
    this.ftl.setText((CharSequence)localObject1);
    this.ftl.setHint(2131762676);
    if (bt.ai((CharSequence)localObject2)) {}
    for (localObject1 = getString(2131762622);; localObject1 = localObject2)
    {
      ((View)localObject3).setVisibility(0);
      ((TextView)findViewById(2131297970)).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, getString(2131761316, new Object[] { localObject1 })));
      localObject1 = (TextView)findViewById(2131297971);
      if (!bt.ai((CharSequence)localObject2)) {
        ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(196642);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setText(this.ftt);
            ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).setSelection(ModRemarkRoomNameUI.a(ModRemarkRoomNameUI.this).getText().length());
            this.ftu.setVisibility(8);
            AppMethodBeat.o(196642);
          }
        });
      }
      for (;;)
      {
        this.fts = getString(2131763304);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI
 * JD-Core Version:    0.7.0.1
 */