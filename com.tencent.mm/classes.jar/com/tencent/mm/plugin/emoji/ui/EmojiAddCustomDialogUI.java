package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.h.a.cx;
import com.tencent.mm.h.a.cx.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.bsl;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.protocal.c.fh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiAddCustomDialogUI
  extends MMBaseActivity
  implements f
{
  private ProgressDialog faz;
  private int fzn;
  private String ghQ;
  private boolean ihj;
  private String jci;
  private String jcj;
  private EmojiInfo jck;
  private boolean jcl;
  private String jcm;
  private List<String> jcn;
  private String jco;
  private com.tencent.mm.ui.widget.a.c jcp;
  private com.tencent.mm.ui.widget.a.c jcq;
  private Context mContext;
  private ah mHandler = new EmojiAddCustomDialogUI.1(this);
  
  private void AX(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(this.jck.Wv()))) {
      this.jck = i.getEmojiStorageMgr().uBb.acC(paramString);
    }
    y.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
    int i;
    if (this.jck.field_catalog != EmojiInfo.uCZ)
    {
      this.jck.field_catalog = EmojiInfo.uCZ;
      i = i.getEmojiStorageMgr().uBb.cwS();
      if (i >= l.aHC()) {
        break label441;
      }
      i = l.aHC();
    }
    for (;;)
    {
      this.jck.field_reserved3 = i;
      i.getEmojiStorageMgr().uBb.q(this.jck);
      com.tencent.mm.plugin.report.service.h.nFQ.f(10431, new Object[] { Integer.valueOf(this.fzn), this.jck.Wv(), this.jck.field_designerID, this.jck.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jck.field_size), this.jcj, this.jck.field_activityid });
      com.tencent.mm.plugin.emoji.e.d.aHc().c(this.jck, false);
      if (this.ihj)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.jck.Wv());
        i.getEmojiStorageMgr().uBb.dJ((List)localObject);
      }
      Object localObject = this.jck.cwL() + "_cover";
      if ((!bk.bl(this.jck.field_thumbUrl)) && (!e.bK((String)localObject)))
      {
        c.a locala = new c.a();
        locala.erh = ((String)localObject);
        locala.erf = true;
        locala.erd = false;
        localObject = locala.OV();
        o.ON().a(this.jck.field_thumbUrl, null, (com.tencent.mm.as.a.a.c)localObject);
      }
      localObject = i.getEmojiStorageMgr().uBc;
      if (!com.tencent.mm.storage.emotion.a.cwo()) {
        i.getEmojiStorageMgr().uBc.cwp();
      }
      aIR();
      aIJ();
      com.tencent.mm.ui.base.h.bC(this.mContext, ae.getContext().getString(f.h.app_added));
      localObject = new Intent();
      ((Intent)localObject).putExtra("extra_id", paramString);
      ((Intent)localObject).putExtra("activityId", this.jck.field_activityid);
      setResult(-1, (Intent)localObject);
      finish();
      return;
      label441:
      i += 1;
    }
  }
  
  private void AY(String paramString)
  {
    this.jcq = com.tencent.mm.ui.base.h.b(this, paramString, "", true);
    this.jcq.setOnDismissListener(new EmojiAddCustomDialogUI.9(this));
  }
  
  private void Wi()
  {
    y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
    new com.tencent.mm.plugin.emoji.f.a(this.jck, this.jcl, this.ihj, this.jcm, this.jcn, this.jco).iZc = new EmojiAddCustomDialogUI.3(this);
  }
  
  private void aIQ()
  {
    y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
    aIJ();
    com.tencent.mm.ui.base.h.bC(this.mContext, ae.getContext().getString(f.h.emoji_add_failed));
    com.tencent.mm.plugin.report.service.h.nFQ.f(10431, new Object[] { Integer.valueOf(this.fzn), this.jck.Wv(), this.jck.field_designerID, this.jck.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.jck.field_size), this.jcj, this.jck.field_activityid });
    setResult(1);
    finish();
  }
  
  private static void aIR()
  {
    Object localObject = new cx();
    ((cx)localObject).bIZ.type = 1;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (!((cx)localObject).bJa.bJb)
    {
      localObject = i.getEmojiStorageMgr().uBe.aHm();
      if (localObject != null)
      {
        Iterator localIterator = ((bsl)localObject).tIZ.iterator();
        while (localIterator.hasNext())
        {
          bsm localbsm = (bsm)localIterator.next();
          if (localbsm.syc.equals(String.valueOf(EmojiGroupInfo.uCR))) {
            localbsm.sAr = 0;
          }
        }
      }
      i.getEmojiStorageMgr().uBe.b((bsl)localObject);
      com.tencent.mm.ca.a.cpp();
      localObject = com.tencent.mm.ca.a.uaN;
      a.b.YJ(String.valueOf(EmojiGroupInfo.uCR));
    }
  }
  
  private void aIS()
  {
    this.jcp = com.tencent.mm.ui.base.h.a(this.mContext, f.h.emoji_upper_limit_warning, f.h.app_empty_string, f.h.emoji_store_mgr_alert, f.h.app_cancel, new EmojiAddCustomDialogUI.4(this), new EmojiAddCustomDialogUI.5(this));
    if (this.jcp != null) {
      this.jcp.setOnDismissListener(new EmojiAddCustomDialogUI.6(this));
    }
  }
  
  private void k(EmojiInfo paramEmojiInfo)
  {
    y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate %b", new Object[] { Boolean.valueOf(paramEmojiInfo.cwF()) });
    if (paramEmojiInfo.cwF())
    {
      Wi();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.Wv());
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.d(4, localArrayList);
    g.DO().dJT.a(paramEmojiInfo, 0);
  }
  
  protected final void aIJ()
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1001);
    }
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(0);
    }
    this.mContext = this;
    this.ghQ = getIntent().getStringExtra("extra_id");
    this.fzn = getIntent().getIntExtra("extra_scence", -1);
    this.jcj = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.jcj == null)) {
      this.jcj = q.Gj();
    }
    this.ihj = getIntent().getBooleanExtra("extra_move_to_top", false);
    this.jcl = getIntent().getBooleanExtra("key_is_selfie", false);
    this.jcm = getIntent().getStringExtra("key_attached_text");
    this.jcn = getIntent().getStringArrayListExtra("key_attached_emoji_md5");
    this.jco = getIntent().getStringExtra("key_imitate_md5");
    if (bk.bl(this.ghQ))
    {
      y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.jck = i.getEmojiStorageMgr().uBb.acC(this.ghQ);
    g.DO().dJT.a(698, this);
    g.DO().dJT.a(423, this);
    this.mHandler.sendEmptyMessageDelayed(1001, 300L);
    Object localObject = this.mContext;
    paramBundle = this.jck;
    if (localObject == null)
    {
      y.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
      return;
    }
    if (paramBundle == null)
    {
      y.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
      return;
    }
    localObject = com.tencent.mm.ui.tools.a.b.aen(paramBundle.cwL());
    ((com.tencent.mm.ui.tools.a.b)localObject).mSize = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(paramBundle, this.jcl);
    ((com.tencent.mm.ui.tools.a.b)localObject).If(com.tencent.mm.m.b.Ag()).a(new EmojiAddCustomDialogUI.2(this, paramBundle));
  }
  
  protected void onDestroy()
  {
    g.DO().dJT.b(698, this);
    g.DO().dJT.b(423, this);
    if (this.mHandler != null) {
      this.mHandler.removeMessages(1001);
    }
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = paramm.getType();
    if (i == 698)
    {
      paramString = (com.tencent.mm.plugin.emoji.f.d)paramm;
      if (paramString.fgi == 3) {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          AX(this.jci);
        }
      }
    }
    while (i != 423)
    {
      return;
      if (paramInt2 == -434)
      {
        y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
        aIJ();
        aIS();
        com.tencent.mm.plugin.report.service.h.nFQ.f(10431, new Object[] { Integer.valueOf(this.fzn), this.jck.Wv(), this.jck.field_designerID, this.jck.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.jck.field_size), this.jcj, this.jck.field_activityid });
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
        paramString = (fh)paramString.dmK.ecF.ecN;
        if ((paramString != null) && (paramString.syW != null) && (paramString.syW.size() > 0))
        {
          y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramString.syW.size()) });
          Wi();
          return;
        }
        AX(null);
        return;
      }
      aIQ();
      return;
    }
    paramString = (com.tencent.mm.plugin.emoji.f.h)paramm;
    if ((paramString != null) && (!bk.bl(paramString.iZD)) && (this.jck != null) && (!bk.bl(this.jck.field_groupId)) && (this.jck.field_groupId.equalsIgnoreCase(paramString.iZD)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        k(this.jck);
        return;
      }
      if (paramInt2 == 4)
      {
        aIJ();
        AY(getString(f.h.emoji_add_failed_no_play));
        return;
      }
      if (paramInt2 == 8)
      {
        aIJ();
        AY(getString(f.h.emoji_add_failed_no_area));
        return;
      }
      if (paramInt2 == 9)
      {
        aIJ();
        AY(getString(f.h.emoji_add_failed_expired));
        return;
      }
      if (paramInt2 == -2)
      {
        aIJ();
        AY(getString(f.h.emoji_add_failed_no_try));
        return;
      }
      aIJ();
      AY(getString(f.h.emoji_add_failed));
      return;
    }
    y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI
 * JD-Core Version:    0.7.0.1
 */