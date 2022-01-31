package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.emoji.f.a;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.c.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class EmojiStoreV2SingleProductDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.ah.f
{
  public String djD;
  private com.tencent.mm.ui.widget.a.c eQV;
  private ProgressBar fsc;
  private int fzn;
  private d.a iYa = new EmojiStoreV2SingleProductDialogUI.6(this);
  private long iYu;
  private com.tencent.mm.ui.widget.a.c jcq;
  private ut jhQ = new ut();
  private EmojiInfo jhR;
  private View jhS;
  private MMAnimateView jhT;
  private ImageView jhU;
  private Button jhV;
  private Button jhW;
  private int jhX;
  private int jhY;
  private boolean jhZ;
  private DialogInterface.OnClickListener jia = new EmojiStoreV2SingleProductDialogUI.1(this);
  private DialogInterface.OnClickListener jib = new EmojiStoreV2SingleProductDialogUI.2(this);
  private View.OnClickListener jic = new EmojiStoreV2SingleProductDialogUI.3(this);
  private com.tencent.mm.as.a.c.i jid = new EmojiStoreV2SingleProductDialogUI.4(this);
  private com.tencent.mm.sdk.b.c jie = new EmojiStoreV2SingleProductDialogUI.5(this);
  private ah mHandler = new ah();
  private String mPath;
  
  private void AY(String paramString)
  {
    this.jcq = com.tencent.mm.ui.base.h.b(this, paramString, "", true);
    this.jcq.setOnDismissListener(new EmojiStoreV2SingleProductDialogUI.9(this));
  }
  
  private void a(String paramString, ut paramut)
  {
    if ((bk.bl(paramString)) || (paramut == null))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "username or emoji is null.");
      return;
    }
    Object localObject = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(paramut.jnU);
    int i;
    if (localObject == null)
    {
      String str = EmojiLogic.J(com.tencent.mm.plugin.emoji.h.b.FL(), paramut.syc, paramut.jnU);
      if (com.tencent.mm.vfs.e.bK(str))
      {
        if (!o.Za(str)) {
          break label211;
        }
        i = EmojiInfo.uDb;
        label75:
        localObject = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.c(paramut.jnU, "", EmojiInfo.uCT, i, (int)com.tencent.mm.vfs.e.aeQ(str), "");
        ((EmojiInfo)localObject).field_designerID = paramut.sRs;
        ((EmojiInfo)localObject).field_groupId = paramut.syc;
        ((EmojiInfo)localObject).field_thumbUrl = paramut.mQp;
      }
    }
    for (paramut = (ut)localObject;; paramut = (ut)localObject)
    {
      paramString = bk.G(bk.aM(paramString, "").split(",")).iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        if (paramut != null)
        {
          com.tencent.mm.plugin.emoji.model.i.aHP().a((String)localObject, paramut, null);
          setResult(-1);
          finish();
          overridePendingTransition(f.a.pop_in, f.a.pop_out);
        }
      }
      break;
      label211:
      i = EmojiInfo.uDa;
      break label75;
      ((EmojiInfo)localObject).field_designerID = paramut.sRs;
      ((EmojiInfo)localObject).field_groupId = paramut.syc;
      ((EmojiInfo)localObject).field_thumbUrl = paramut.mQp;
    }
  }
  
  private void aJD()
  {
    if ((this.jhR != null) && (this.jhR.field_catalog == EmojiGroupInfo.uCS))
    {
      this.jhW.setEnabled(false);
      this.jhW.setText(f.h.app_added);
      this.jhW.setTextColor(getResources().getColor(f.b.grey_btn_color_disable));
      return;
    }
    if (com.tencent.mm.vfs.e.bK(this.mPath))
    {
      this.jhW.setEnabled(true);
      this.jhW.setText(f.h.emoji_store_add_emoji);
      this.jhW.setTextColor(getResources().getColor(f.b.green_text_color));
      return;
    }
    this.jhW.setEnabled(false);
    this.jhW.setEnabled(false);
    this.jhW.setText(f.h.emoji_store_add_emoji);
    this.jhW.setTextColor(getResources().getColor(f.b.grey_btn_color_disable));
  }
  
  private void aJm()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new EmojiStoreV2SingleProductDialogUI.8(this));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 9001) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("Select_Conv_User");
      if ((!bk.bl(str)) && (this.jhQ != null))
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "UserName:%s ,MD5:%s", new Object[] { str, this.jhQ.jnU });
        a(str, this.jhQ);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        com.tencent.mm.plugin.messenger.a.g.bhI().dO(paramIntent, str);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(f.f.transparent_background);
    this.jhX = getIntent().getIntExtra("add_source", 5);
    this.jhY = getIntent().getIntExtra("entrance_scene", 0);
    this.fzn = getIntent().getIntExtra("scene", 0);
    this.jhZ = getIntent().getBooleanExtra("need_exchange", false);
    this.iYu = getIntent().getLongExtra("searchID", 0L);
    this.djD = getIntent().getStringExtra("Select_Conv_User");
    paramBundle = getIntent().getByteArrayExtra("extra_object");
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        this.jhQ = ((ut)this.jhQ.aH(paramBundle));
        if (this.jhQ != null)
        {
          this.jhR = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(this.jhQ.jnU);
          if ((this.jhR != null) && (!bk.bl(this.jhR.field_groupId)) && (bk.bl(this.jhQ.syc))) {
            this.jhQ.syc = this.jhR.field_groupId;
          }
        }
        com.tencent.mm.sdk.b.a.udP.c(this.jie);
        com.tencent.mm.plugin.emoji.model.i.aHO().iYa = this.iYa;
        this.jhS = com.tencent.mm.ui.y.gt(this).inflate(f.f.emoji_store_v2_single_product_dialog, null);
        this.fsc = ((ProgressBar)this.jhS.findViewById(f.e.dialog_loading));
        this.jhT = ((MMAnimateView)this.jhS.findViewById(f.e.dialog_image));
        this.jhU = ((ImageView)this.jhS.findViewById(f.e.dialog_close));
        this.jhU.setOnClickListener(this.jic);
        paramBundle = this.jhS;
        if ((!(this instanceof Activity)) || (!((Activity)this).isFinishing())) {
          break label599;
        }
        paramBundle = null;
        this.eQV = paramBundle;
        this.eQV.a(getString(f.h.app_send), false, this.jia);
        this.eQV.b(getString(f.h.app_added), false, this.jib);
        this.eQV.setOnDismissListener(new EmojiStoreV2SingleProductDialogUI.7(this));
        this.jhV = this.eQV.getButton(-1);
        this.jhV.setTextColor(getResources().getColor(f.b.green_text_color));
        this.jhW = this.eQV.getButton(-2);
        this.mPath = EmojiLogic.J(com.tencent.mm.plugin.emoji.h.b.FL(), this.jhQ.syc, this.jhQ.jnU);
        if (com.tencent.mm.vfs.e.aeQ(this.mPath) <= 0L) {
          break label658;
        }
        this.jhT.setVisibility(0);
        this.fsc.setVisibility(8);
        this.jhR = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(this.jhQ.jnU);
        if ((this.jhR == null) || ((this.jhR.field_reserved4 & EmojiInfo.uDo) != EmojiInfo.uDo)) {
          break label644;
        }
        this.jhT.h(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.jhR), "");
        aJD();
        com.tencent.mm.kernel.g.DO().dJT.a(423, this);
        return;
      }
      catch (IOException paramBundle)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", paramBundle, "", new Object[0]);
      }
      setResult(0);
      finish();
      continue;
      label599:
      Object localObject = new c.a(this);
      ((c.a)localObject).aez("");
      ((c.a)localObject).ei(paramBundle);
      ((c.a)localObject).nW(true);
      paramBundle = ((c.a)localObject).aoP();
      paramBundle.show();
      com.tencent.mm.ui.base.h.a(this, paramBundle);
      continue;
      label644:
      this.jhT.setImageFilePath(this.mPath);
      continue;
      label658:
      this.jhT.setVisibility(8);
      this.fsc.setVisibility(0);
      this.jhW.setText(f.h.emoji_store_add_emoji);
      this.jhV.setText(f.h.app_send);
      this.jhW.setEnabled(false);
      this.jhW.setTextColor(getResources().getColor(f.b.grey_btn_color_disable));
      this.jhV.setEnabled(false);
      this.jhV.setTextColor(getResources().getColor(f.b.grey_btn_color_disable));
      paramBundle = com.tencent.mm.plugin.emoji.model.i.aHr();
      localObject = this.jhQ.kSC;
      String str = this.jhQ.kSC;
      paramBundle.a((String)localObject, null, com.tencent.mm.plugin.emoji.e.e.o(this.mPath, new Object[] { this.jhQ }), this.jid);
      if (!bk.bl(this.jhQ.mQp))
      {
        paramBundle = com.tencent.mm.plugin.emoji.model.i.aHr();
        localObject = this.jhQ.mQp;
        str = this.jhQ.mQp;
        paramBundle.a((String)localObject, com.tencent.mm.plugin.emoji.e.e.o(this.mPath + "_cover", new Object[0]), null);
      }
    }
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.jie);
    com.tencent.mm.plugin.emoji.model.i.aHO().iYa = null;
    super.onDestroy();
    com.tencent.mm.kernel.g.DO().dJT.b(423, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.jhR = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().uBb.acC(this.jhQ.jnU);
    aJm();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 423)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "exchange back %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramm;
      if ((bk.bl(paramString.iZD)) || (this.jhQ == null) || (bk.bl(this.jhQ.syc)) || (!this.jhQ.syc.equalsIgnoreCase(paramString.iZD))) {
        break label272;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label243;
      }
      paramString = this.jhQ;
      if (!bk.bl(this.djD)) {
        break label233;
      }
      paramm = new Intent();
      paramm.putExtra("Select_Conv_Type", 3);
      paramm.putExtra("select_is_ret", true);
      paramm.putExtra("mutil_select_is_ret", true);
      paramm.putExtra("Retr_Msg_Type", 5);
      if (this.jhR == null) {
        break label217;
      }
      paramm.putExtra("Retr_Msg_thumb_path", paramString.jnU);
    }
    for (;;)
    {
      paramm.putExtra("MMActivity.OverrideEnterAnimation", f.a.fast_faded_in);
      com.tencent.mm.br.d.c(this, ".ui.transmit.SelectConversationUI", paramm, 9001);
      overridePendingTransition(f.a.push_up_in, f.a.fast_faded_out);
      return;
      label217:
      paramm.putExtra("image_path", this.mPath);
    }
    label233:
    a(this.djD, paramString);
    return;
    label243:
    if (paramInt2 == 4)
    {
      AY(getString(f.h.emoji_send_need_exchange));
      return;
    }
    AY(getString(f.h.emoji_add_failed));
    return;
    label272:
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "no the same product ID");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI
 * JD-Core Version:    0.7.0.1
 */