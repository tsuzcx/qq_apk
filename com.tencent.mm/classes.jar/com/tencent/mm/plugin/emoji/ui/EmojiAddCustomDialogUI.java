package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ed;
import com.tencent.mm.autogen.a.ed.b;
import com.tencent.mm.cc.a.b;
import com.tencent.mm.emoji.c.m;
import com.tencent.mm.emoji.e.d.a;
import com.tencent.mm.emoji.e.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.protocal.protobuf.fdc;
import com.tencent.mm.protocal.protobuf.fdd;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiAddCustomDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.am.h
{
  private Context mContext;
  private int mScene;
  private ProgressDialog pNH;
  private String ryW;
  private boolean vIy;
  private String xRo;
  private EmojiInfo xRp;
  private boolean xRq;
  private com.tencent.mm.emoji.e.d xRr;
  private e xRs;
  private e xRt;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> xRu;
  private Runnable xRv;
  
  public EmojiAddCustomDialogUI()
  {
    AppMethodBeat.i(108842);
    this.xRv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108829);
        EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(h.h.emoji_store_watting_add));
        AppMethodBeat.o(108829);
      }
    };
    AppMethodBeat.o(108842);
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(108849);
    if (isFinishing())
    {
      AppMethodBeat.o(108849);
      return;
    }
    this.xRt = k.c(this, paramString, "", true);
    this.xRt.setOnDismissListener(new EmojiAddCustomDialogUI.3(this));
    AppMethodBeat.o(108849);
  }
  
  private static void dBu()
  {
    AppMethodBeat.i(108846);
    Object localObject = new ed();
    ((ed)localObject).hDT.type = 1;
    ((ed)localObject).publish();
    if (!((ed)localObject).hDU.hDV)
    {
      localObject = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.jdK();
      if (localObject != null)
      {
        Iterator localIterator = ((fdc)localObject).abCG.iterator();
        while (localIterator.hasNext())
        {
          fdd localfdd = (fdd)localIterator.next();
          if (localfdd.ProductID.equals(String.valueOf(EmojiGroupInfo.aklE))) {
            localfdd.crs = 0;
          }
        }
      }
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adjx.a((fdc)localObject);
      com.tencent.mm.cc.a.iRg();
      localObject = com.tencent.mm.cc.a.aclv;
      a.b.btU(String.valueOf(EmojiGroupInfo.aklE));
    }
    AppMethodBeat.o(108846);
  }
  
  private void dBv()
  {
    AppMethodBeat.i(108848);
    if (isFinishing())
    {
      AppMethodBeat.o(108848);
      return;
    }
    this.xRs = k.a(this.mContext, h.h.emoji_upper_limit_warning, h.h.app_empty_string, h.h.emoji_store_mgr_alert, h.h.app_cancel, new EmojiAddCustomDialogUI.10(this), new EmojiAddCustomDialogUI.11(this));
    if (this.xRs != null) {
      this.xRs.setOnDismissListener(new EmojiAddCustomDialogUI.12(this));
    }
    AppMethodBeat.o(108848);
  }
  
  private void v(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108847);
    Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.getMd5());
    paramEmojiInfo = new com.tencent.mm.emoji.sync.b(0, 4, localArrayList);
    paramEmojiInfo.otr = true;
    paramEmojiInfo.bFJ().a(this.xRu).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(com.tencent.mm.am.b.a<iw> paramAnonymousa)
      {
        AppMethodBeat.i(270341);
        int i = paramAnonymousa.errType;
        int j = paramAnonymousa.errCode;
        if (j == -434)
        {
          Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acId, Boolean.TRUE);
          EmojiAddCustomDialogUI.this.dismissLoadingDialog();
          EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
          com.tencent.mm.plugin.report.service.h.OAn.b(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.c(EmojiAddCustomDialogUI.this)), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).getMd5(), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_designerID, EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_size), EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_activityid });
        }
        for (;;)
        {
          paramAnonymousa = aguz;
          AppMethodBeat.o(270341);
          return paramAnonymousa;
          if ((i == 0) && (j == 0))
          {
            Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
            paramAnonymousa = (iw)paramAnonymousa.ott;
            if ((paramAnonymousa != null) && (paramAnonymousa.YKI != null) && (paramAnonymousa.YKI.size() > 0))
            {
              Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramAnonymousa.YKI.size()) });
              EmojiAddCustomDialogUI.f(EmojiAddCustomDialogUI.this);
            }
            else
            {
              EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this, null);
            }
          }
          else
          {
            EmojiAddCustomDialogUI.g(EmojiAddCustomDialogUI.this);
          }
        }
      }
    });
    AppMethodBeat.o(108847);
  }
  
  protected final void dismissLoadingDialog()
  {
    AppMethodBeat.i(108850);
    MMHandlerThread.removeRunnable(this.xRv);
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    AppMethodBeat.o(108850);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108843);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    this.mContext = this;
    this.xRu = new com.tencent.mm.vending.e.c();
    this.ryW = getIntent().getStringExtra("extra_id");
    this.mScene = getIntent().getIntExtra("extra_scence", -1);
    this.xRo = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.xRo == null)) {
      this.xRo = z.bAM();
    }
    this.vIy = getIntent().getBooleanExtra("extra_move_to_top", true);
    this.xRq = getIntent().getBooleanExtra("key_is_selfie", false);
    if (Util.isNullOrNil(this.ryW))
    {
      Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.xRp = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(this.ryW);
    com.tencent.mm.kernel.h.baD().mCm.a(423, this);
    MMHandlerThread.postToMainThreadDelayed(this.xRv, 300L);
    Object localObject = this.mContext;
    paramBundle = this.xRp;
    if (localObject == null)
    {
      Log.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108843);
      return;
    }
    if (paramBundle == null)
    {
      Log.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108843);
      return;
    }
    localObject = m.mhY;
    if (m.getKV().getBoolean("custom_full", false))
    {
      Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      dismissLoadingDialog();
      dBv();
      com.tencent.mm.plugin.report.service.h.OAn.b(10431, new Object[] { Integer.valueOf(this.mScene), this.xRp.getMd5(), this.xRp.field_designerID, this.xRp.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.xRp.field_size), this.xRo, this.xRp.field_activityid });
      AppMethodBeat.o(108843);
      return;
    }
    if ((paramBundle.field_catalog == EmojiInfo.aklM) || (Util.isNullOrNil(paramBundle.field_groupId)) || (Util.isEqual(paramBundle.field_groupId, "capture")) || (com.tencent.mm.emoji.f.f.Ey(paramBundle.field_groupId)) || (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoj(paramBundle.field_groupId)))
    {
      v(paramBundle);
      AppMethodBeat.o(108843);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.emoji.e.h(paramBundle.field_groupId, (byte)0);
    com.tencent.mm.kernel.h.baD().mCm.a(paramBundle, 0);
    AppMethodBeat.o(108843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108844);
    com.tencent.mm.kernel.h.baD().mCm.b(423, this);
    MMHandlerThread.removeRunnable(this.xRv);
    super.onDestroy();
    this.xRu.dead();
    if (this.xRr != null) {
      this.xRr.mof = null;
    }
    AppMethodBeat.o(108844);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(108845);
    if (paramp.getType() == 423)
    {
      if (!(paramp instanceof com.tencent.mm.plugin.emoji.e.h))
      {
        AppMethodBeat.o(108845);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.e.h)paramp;
      if ((paramString != null) && (!Util.isNullOrNil(paramString.xOk)) && (this.xRp != null) && (!Util.isNullOrNil(this.xRp.field_groupId)) && (this.xRp.field_groupId.equalsIgnoreCase(paramString.xOk)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          v(this.xRp);
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 4)
        {
          dismissLoadingDialog();
          if (this.mScene == 0)
          {
            paramString = this.xRp.field_groupId;
            if (!isFinishing())
            {
              this.xRt = k.c(this, getString(h.h.emoji_add_failed_no_play), "", true);
              this.xRt.b(h.h.app_cancel, new EmojiAddCustomDialogUI.4(this));
              this.xRt.a(h.h.emoji_add_fialed_non_purchase_goto, new EmojiAddCustomDialogUI.5(this, paramString));
            }
            AppMethodBeat.o(108845);
            return;
          }
          aoP(getString(h.h.emoji_add_failed_no_play));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 8)
        {
          dismissLoadingDialog();
          aoP(getString(h.h.emoji_add_failed_no_area));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 9)
        {
          dismissLoadingDialog();
          aoP(getString(h.h.emoji_add_failed_expired));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == -2)
        {
          dismissLoadingDialog();
          aoP(getString(h.h.emoji_add_failed_no_try));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == -100000)
        {
          dismissLoadingDialog();
          aoP(getString(h.h.emoji_add_failed_activity));
          AppMethodBeat.o(108845);
          return;
        }
        dismissLoadingDialog();
        aoP(getString(h.h.emoji_add_failed));
        AppMethodBeat.o(108845);
        return;
      }
      Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(108845);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI
 * JD-Core Version:    0.7.0.1
 */