package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.b.c;
import java.io.IOException;

public class EmojiStoreV2SingleProductDialogUI
  extends MMBaseActivity
{
  public String eaX;
  private EmojiInfo evH;
  private ProgressBar gJE;
  private c giQ;
  private long lhz;
  private View lqM;
  private EmojiStatusView lqN;
  private ImageView lqO;
  private Button lqP;
  private Button lqQ;
  private int lqR;
  private int lqS;
  private DialogInterface.OnClickListener lqT;
  private DialogInterface.OnClickListener lqU;
  private View.OnClickListener lqV;
  private int mScene;
  
  public EmojiStoreV2SingleProductDialogUI()
  {
    AppMethodBeat.i(53735);
    this.lqT = new EmojiStoreV2SingleProductDialogUI.1(this);
    this.lqU = new EmojiStoreV2SingleProductDialogUI.2(this);
    this.lqV = new EmojiStoreV2SingleProductDialogUI.3(this);
    AppMethodBeat.o(53735);
  }
  
  private void bna()
  {
    AppMethodBeat.i(53739);
    if ((this.evH != null) && (this.evH.field_catalog == EmojiGroupInfo.yPf))
    {
      this.lqQ.setEnabled(false);
      this.lqQ.setText(2131296540);
      this.lqQ.setTextColor(getResources().getColor(2131690149));
      AppMethodBeat.o(53739);
      return;
    }
    if ((this.evH != null) && (this.evH.dzn()))
    {
      this.lqQ.setEnabled(true);
      this.lqQ.setText(2131299182);
      this.lqQ.setTextColor(getResources().getColor(2131689778));
      AppMethodBeat.o(53739);
      return;
    }
    this.lqQ.setEnabled(false);
    this.lqQ.setText(2131299182);
    this.lqQ.setTextColor(getResources().getColor(2131690149));
    AppMethodBeat.o(53739);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53738);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      this.giQ.setOnDismissListener(null);
      this.giQ.dismiss();
      setResult(-1);
      finish();
      overridePendingTransition(2131034217, 0);
    }
    AppMethodBeat.o(53738);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53736);
    overridePendingTransition(-1, -1);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    this.lqR = getIntent().getIntExtra("add_source", 5);
    this.lqS = getIntent().getIntExtra("entrance_scene", 0);
    this.mScene = getIntent().getIntExtra("scene", 0);
    this.lhz = getIntent().getLongExtra("searchID", 0L);
    this.eaX = getIntent().getStringExtra("Select_Conv_User");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    try
    {
      zg localzg = new zg();
      localzg.parseFrom(paramBundle);
      this.evH = i.getEmojiStorageMgr().yNn.asP(localzg.Md5);
      if (this.evH == null)
      {
        this.evH = new EmojiInfo();
        this.evH.field_catalog = 84;
        this.evH.field_reserved4 |= EmojiInfo.APx;
        b.a(localzg, this.evH);
      }
      if (this.evH == null)
      {
        setResult(0);
        finish();
      }
      this.lqM = w.hM(this).inflate(2130969411, null);
      this.gJE = ((ProgressBar)this.lqM.findViewById(2131823705));
      this.lqN = ((EmojiStatusView)this.lqM.findViewById(2131823704));
      this.lqO = ((ImageView)this.lqM.findViewById(2131823703));
      this.lqO.setOnClickListener(this.lqV);
      this.giQ = h.a(this, this.lqM, "");
      this.giQ.a(getString(2131297067), false, this.lqT);
      this.giQ.b(getString(2131296540), false, this.lqU);
      this.giQ.setOnDismissListener(new EmojiStoreV2SingleProductDialogUI.4(this));
      this.lqP = this.giQ.getButton(-1);
      this.lqQ = this.giQ.getButton(-2);
      this.lqN.setVisibility(8);
      this.gJE.setVisibility(0);
      this.lqQ.setText(2131299182);
      this.lqP.setText(2131297067);
      this.lqQ.setEnabled(false);
      this.lqQ.setTextColor(getResources().getColor(2131690149));
      this.lqP.setEnabled(false);
      this.lqP.setTextColor(getResources().getColor(2131690149));
      this.lqN.setStatusListener(new EmojiStoreV2SingleProductDialogUI.5(this));
      this.lqN.setEmojiInfo(this.evH);
      AppMethodBeat.o(53736);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53740);
    super.onDestroy();
    this.giQ.setOnDismissListener(null);
    if (this.giQ.isShowing()) {
      this.giQ.dismiss();
    }
    AppMethodBeat.o(53740);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53737);
    super.onResume();
    if (this.evH != null)
    {
      EmojiInfo localEmojiInfo = i.getEmojiStorageMgr().yNn.asP(this.evH.field_md5);
      if (localEmojiInfo != null) {
        this.evH = localEmojiInfo;
      }
    }
    bna();
    this.giQ.show();
    AppMethodBeat.o(53737);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI
 * JD-Core Version:    0.7.0.1
 */