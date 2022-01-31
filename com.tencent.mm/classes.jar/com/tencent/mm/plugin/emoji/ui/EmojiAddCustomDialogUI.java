package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.da.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EmojiAddCustomDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.ai.f
{
  private ProgressDialog gsr;
  private String hyD;
  private boolean jXf;
  private String lkS;
  private String lkT;
  private EmojiInfo lkU;
  private boolean lkV;
  private String lkW;
  private List<String> lkX;
  private String lkY;
  private com.tencent.mm.emoji.a.f lkZ;
  private com.tencent.mm.ui.widget.b.c lla;
  private com.tencent.mm.ui.widget.b.c llb;
  private Runnable llc;
  private Context mContext;
  private int mScene;
  
  public EmojiAddCustomDialogUI()
  {
    AppMethodBeat.i(53278);
    this.llc = new EmojiAddCustomDialogUI.1(this);
    AppMethodBeat.o(53278);
  }
  
  private void KZ(String paramString)
  {
    AppMethodBeat.i(53283);
    if ((paramString != null) && (!paramString.equals(this.lkU.Al()))) {
      this.lkU = i.getEmojiStorageMgr().yNn.asP(paramString);
    }
    ab.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
    int i;
    if (this.lkU.field_catalog != EmojiInfo.yPm)
    {
      this.lkU.field_catalog = EmojiInfo.yPm;
      i = i.getEmojiStorageMgr().yNn.dzD();
      if (i >= com.tencent.mm.emoji.a.h.OK()) {
        break label429;
      }
      i = com.tencent.mm.emoji.a.h.OK();
    }
    for (;;)
    {
      this.lkU.field_reserved3 = i;
      i.getEmojiStorageMgr().yNn.J(this.lkU);
      com.tencent.mm.plugin.report.service.h.qsU.e(10431, new Object[] { Integer.valueOf(this.mScene), this.lkU.Al(), this.lkU.field_designerID, this.lkU.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.lkU.field_size), this.lkT, this.lkU.field_activityid });
      com.tencent.mm.plugin.emoji.e.f.bkQ().c(this.lkU, false);
      if (this.jXf)
      {
        localObject = new ArrayList();
        ((List)localObject).add(this.lkU.Al());
        i.getEmojiStorageMgr().yNn.l(0, (List)localObject);
      }
      Object localObject = this.lkU.dQB() + "_cover";
      if ((!bo.isNullOrNil(this.lkU.field_thumbUrl)) && (!com.tencent.mm.vfs.e.cN((String)localObject)))
      {
        c.a locala = new c.a();
        locala.eNO = ((String)localObject);
        locala.eNM = true;
        locala.eNK = false;
        localObject = locala.ahY();
        o.ahG().a(this.lkU.field_thumbUrl, null, (com.tencent.mm.at.a.a.c)localObject);
      }
      bmp();
      bmh();
      com.tencent.mm.ui.base.h.bO(this.mContext, ah.getContext().getString(2131296540));
      localObject = new Intent();
      ((Intent)localObject).putExtra("extra_id", paramString);
      ((Intent)localObject).putExtra("activityId", this.lkU.field_activityid);
      setResult(-1, (Intent)localObject);
      finish();
      AppMethodBeat.o(53283);
      return;
      label429:
      i += 1;
    }
  }
  
  private void La(String paramString)
  {
    AppMethodBeat.i(53287);
    if (isFinishing())
    {
      AppMethodBeat.o(53287);
      return;
    }
    this.llb = com.tencent.mm.ui.base.h.b(this, paramString, "", true);
    this.llb.setOnDismissListener(new EmojiAddCustomDialogUI.9(this));
    AppMethodBeat.o(53287);
  }
  
  private void bmo()
  {
    AppMethodBeat.i(53282);
    ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
    bmh();
    com.tencent.mm.ui.base.h.bO(this.mContext, ah.getContext().getString(2131299094));
    com.tencent.mm.plugin.report.service.h.qsU.e(10431, new Object[] { Integer.valueOf(this.mScene), this.lkU.Al(), this.lkU.field_designerID, this.lkU.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.lkU.field_size), this.lkT, this.lkU.field_activityid });
    setResult(1);
    finish();
    AppMethodBeat.o(53282);
  }
  
  private static void bmp()
  {
    AppMethodBeat.i(53284);
    Object localObject = new da();
    ((da)localObject).cqt.type = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (!((da)localObject).cqu.cqv)
    {
      localObject = i.getEmojiStorageMgr().yNq.blb();
      if (localObject != null)
      {
        Iterator localIterator = ((cda)localObject).xND.iterator();
        while (localIterator.hasNext())
        {
          cdb localcdb = (cdb)localIterator.next();
          if (localcdb.ProductID.equals(String.valueOf(EmojiGroupInfo.yPe))) {
            localcdb.wux = 0;
          }
        }
      }
      i.getEmojiStorageMgr().yNq.b((cda)localObject);
      com.tencent.mm.ca.a.dqM();
      localObject = com.tencent.mm.ca.a.yiH;
      a.b.aoG(String.valueOf(EmojiGroupInfo.yPe));
    }
    AppMethodBeat.o(53284);
  }
  
  private void bmq()
  {
    AppMethodBeat.i(53286);
    if (isFinishing())
    {
      AppMethodBeat.o(53286);
      return;
    }
    this.lla = com.tencent.mm.ui.base.h.a(this.mContext, 2131299287, 2131296919, 2131299211, 2131296888, new EmojiAddCustomDialogUI.4(this), new EmojiAddCustomDialogUI.5(this));
    if (this.lla != null) {
      this.lla.setOnDismissListener(new EmojiAddCustomDialogUI.6(this));
    }
    AppMethodBeat.o(53286);
  }
  
  private static void u(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(53285);
    ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.Al());
    paramEmojiInfo = new com.tencent.mm.plugin.emoji.f.c(0, 4, localArrayList);
    com.tencent.mm.kernel.g.RK().eHt.a(paramEmojiInfo, 0);
    AppMethodBeat.o(53285);
  }
  
  protected final void bmh()
  {
    AppMethodBeat.i(53288);
    al.ae(this.llc);
    if ((this.gsr != null) && (this.gsr.isShowing())) {
      this.gsr.dismiss();
    }
    AppMethodBeat.o(53288);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53279);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    this.mContext = this;
    this.hyD = getIntent().getStringExtra("extra_id");
    this.mScene = getIntent().getIntExtra("extra_scence", -1);
    this.lkT = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.lkT == null)) {
      this.lkT = r.Zn();
    }
    this.jXf = getIntent().getBooleanExtra("extra_move_to_top", false);
    this.lkV = getIntent().getBooleanExtra("key_is_selfie", false);
    this.lkW = getIntent().getStringExtra("key_attached_text");
    this.lkX = getIntent().getStringArrayListExtra("key_attached_emoji_md5");
    this.lkY = getIntent().getStringExtra("key_imitate_md5");
    if (bo.isNullOrNil(this.hyD))
    {
      ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.lkU = i.getEmojiStorageMgr().yNn.asP(this.hyD);
    com.tencent.mm.kernel.g.RK().eHt.a(698, this);
    com.tencent.mm.kernel.g.RK().eHt.a(423, this);
    al.p(this.llc, 300L);
    Object localObject = this.mContext;
    paramBundle = this.lkU;
    if (localObject == null)
    {
      ab.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(53279);
      return;
    }
    if (paramBundle == null)
    {
      ab.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(53279);
      return;
    }
    localObject = com.tencent.mm.ui.tools.b.b.auW(paramBundle.dQB());
    ((com.tencent.mm.ui.tools.b.b)localObject).mSize = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().e(paramBundle, this.lkV);
    ((com.tencent.mm.ui.tools.b.b)localObject).QR(com.tencent.mm.m.b.MV()).a(new EmojiAddCustomDialogUI.2(this, paramBundle));
    AppMethodBeat.o(53279);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53280);
    com.tencent.mm.kernel.g.RK().eHt.b(698, this);
    com.tencent.mm.kernel.g.RK().eHt.b(423, this);
    al.ae(this.llc);
    super.onDestroy();
    if (this.lkZ != null) {
      this.lkZ.ewI = null;
    }
    AppMethodBeat.o(53280);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(53281);
    int i = paramm.getType();
    if (i == 698)
    {
      paramString = (com.tencent.mm.plugin.emoji.f.c)paramm;
      if (paramInt2 == -434)
      {
        ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
        paramString = com.tencent.mm.emoji.a.e.ewz;
        com.tencent.mm.emoji.a.e.cn(true);
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yxU, Boolean.TRUE);
        bmh();
        bmq();
        com.tencent.mm.plugin.report.service.h.qsU.e(10431, new Object[] { Integer.valueOf(this.mScene), this.lkU.Al(), this.lkU.field_designerID, this.lkU.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.lkU.field_size), this.lkT, this.lkU.field_activityid });
        AppMethodBeat.o(53281);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
        paramString = (gq)paramString.rr.fsW.fta;
        if ((paramString != null) && (paramString.wsY != null) && (paramString.wsY.size() > 0))
        {
          ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramString.wsY.size()) });
          ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
          if (this.lkZ != null) {
            this.lkZ.ewI = null;
          }
          this.lkZ = new com.tencent.mm.emoji.a.f(this.lkU, this.lkV, this.jXf, this.lkW, this.lkX, this.lkY);
          this.lkZ.ewI = new EmojiAddCustomDialogUI.3(this);
          AppMethodBeat.o(53281);
          return;
        }
        KZ(null);
        AppMethodBeat.o(53281);
        return;
      }
      bmo();
      AppMethodBeat.o(53281);
      return;
    }
    if (i == 423)
    {
      if (!(paramm instanceof com.tencent.mm.plugin.emoji.f.g))
      {
        AppMethodBeat.o(53281);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramm;
      if ((paramString != null) && (!bo.isNullOrNil(paramString.liu)) && (this.lkU != null) && (!bo.isNullOrNil(this.lkU.field_groupId)) && (this.lkU.field_groupId.equalsIgnoreCase(paramString.liu)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          u(this.lkU);
          AppMethodBeat.o(53281);
          return;
        }
        if (paramInt2 == 4)
        {
          bmh();
          La(getString(2131299097));
          AppMethodBeat.o(53281);
          return;
        }
        if (paramInt2 == 8)
        {
          bmh();
          La(getString(2131299096));
          AppMethodBeat.o(53281);
          return;
        }
        if (paramInt2 == 9)
        {
          bmh();
          La(getString(2131299095));
          AppMethodBeat.o(53281);
          return;
        }
        if (paramInt2 == -2)
        {
          bmh();
          La(getString(2131299098));
          AppMethodBeat.o(53281);
          return;
        }
        bmh();
        La(getString(2131299094));
        AppMethodBeat.o(53281);
        return;
      }
      ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(53281);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI
 * JD-Core Version:    0.7.0.1
 */