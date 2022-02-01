package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.cb.a.b;
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.dh.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.tools.b.b.a;
import com.tencent.mm.vending.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiAddCustomDialogUI
  extends MMBaseActivity
  implements com.tencent.mm.ak.g
{
  private ProgressDialog iFC;
  private String jYv;
  private Context mContext;
  private int mScene;
  private boolean nAP;
  private String peK;
  private EmojiInfo peL;
  private boolean peM;
  private com.tencent.mm.emoji.c.d peN;
  private com.tencent.mm.ui.widget.a.d peO;
  private com.tencent.mm.ui.widget.a.d peP;
  private c<com.tencent.mm.vending.e.a> peQ;
  private Runnable peR;
  
  public EmojiAddCustomDialogUI()
  {
    AppMethodBeat.i(108842);
    this.peR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108829);
        EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(2131758389));
        AppMethodBeat.o(108829);
      }
    };
    AppMethodBeat.o(108842);
  }
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(108849);
    if (isFinishing())
    {
      AppMethodBeat.o(108849);
      return;
    }
    this.peP = com.tencent.mm.ui.base.h.c(this, paramString, "", true);
    this.peP.setOnDismissListener(new EmojiAddCustomDialogUI.3(this));
    AppMethodBeat.o(108849);
  }
  
  private static void cdm()
  {
    AppMethodBeat.i(108846);
    Object localObject = new dh();
    ((dh)localObject).dcK.type = 1;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    if (!((dh)localObject).dcL.dcM)
    {
      localObject = k.getEmojiStorageMgr().GYc.fdv();
      if (localObject != null)
      {
        Iterator localIterator = ((czh)localObject).FIC.iterator();
        while (localIterator.hasNext())
        {
          czi localczi = (czi)localIterator.next();
          if (localczi.ProductID.equals(String.valueOf(EmojiGroupInfo.Jsq))) {
            localczi.DWO = 0;
          }
        }
      }
      k.getEmojiStorageMgr().GYc.a((czh)localObject);
      com.tencent.mm.cb.a.eSf();
      localObject = com.tencent.mm.cb.a.Gju;
      a.b.aJX(String.valueOf(EmojiGroupInfo.Jsq));
    }
    AppMethodBeat.o(108846);
  }
  
  private void cdn()
  {
    AppMethodBeat.i(108848);
    if (isFinishing())
    {
      AppMethodBeat.o(108848);
      return;
    }
    this.peO = com.tencent.mm.ui.base.h.b(this.mContext, 2131758413, 2131755726, 2131758337, 2131755691, new EmojiAddCustomDialogUI.10(this), new EmojiAddCustomDialogUI.11(this));
    if (this.peO != null) {
      this.peO.setOnDismissListener(new EmojiAddCustomDialogUI.12(this));
    }
    AppMethodBeat.o(108848);
  }
  
  private void v(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108847);
    ac.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmojiInfo.JC());
    new com.tencent.mm.emoji.sync.a(0, localArrayList).aBB().a(this.peQ).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(c.a<hr> paramAnonymousa)
      {
        AppMethodBeat.i(207449);
        int i = paramAnonymousa.errType;
        int j = paramAnonymousa.errCode;
        if (j == -434)
        {
          ac.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
          paramAnonymousa = j.fQF;
          j.dn(true);
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GEc, Boolean.TRUE);
          EmojiAddCustomDialogUI.this.cdf();
          EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
          com.tencent.mm.plugin.report.service.h.wUl.f(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.c(EmojiAddCustomDialogUI.this)), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).JC(), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_designerID, EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_size), EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_activityid });
        }
        for (;;)
        {
          paramAnonymousa = Jql;
          AppMethodBeat.o(207449);
          return paramAnonymousa;
          if ((i == 0) && (j == 0))
          {
            ac.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
            paramAnonymousa = (hr)paramAnonymousa.hvj;
            if ((paramAnonymousa != null) && (paramAnonymousa.DVa != null) && (paramAnonymousa.DVa.size() > 0))
            {
              ac.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramAnonymousa.DVa.size()) });
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
  
  protected final void cdf()
  {
    AppMethodBeat.i(108850);
    ap.aB(this.peR);
    if ((this.iFC != null) && (this.iFC.isShowing())) {
      this.iFC.dismiss();
    }
    AppMethodBeat.o(108850);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108843);
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    this.mContext = this;
    this.peQ = new c();
    this.jYv = getIntent().getStringExtra("extra_id");
    this.mScene = getIntent().getIntExtra("extra_scence", -1);
    this.peK = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.peK == null)) {
      this.peK = u.axw();
    }
    this.nAP = getIntent().getBooleanExtra("extra_move_to_top", true);
    this.peM = getIntent().getBooleanExtra("key_is_selfie", false);
    if (bs.isNullOrNil(this.jYv))
    {
      ac.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.peL = k.getEmojiStorageMgr().GXZ.aOT(this.jYv);
    com.tencent.mm.kernel.g.agQ().ghe.a(423, this);
    ap.n(this.peR, 300L);
    Object localObject = this.mContext;
    paramBundle = this.peL;
    if (localObject == null)
    {
      ac.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
      AppMethodBeat.o(108843);
      return;
    }
    if (paramBundle == null)
    {
      ac.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
      AppMethodBeat.o(108843);
      return;
    }
    localObject = j.fQF;
    if (j.getKV().getBoolean("custom_full", false))
    {
      ac.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      cdf();
      cdn();
      com.tencent.mm.plugin.report.service.h.wUl.f(10431, new Object[] { Integer.valueOf(this.mScene), this.peL.JC(), this.peL.field_designerID, this.peL.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.peL.field_size), this.peK, this.peL.field_activityid });
      AppMethodBeat.o(108843);
      return;
    }
    if ((paramBundle.field_catalog == EmojiInfo.Jsy) || (bs.isNullOrNil(paramBundle.field_groupId)) || (bs.lr(paramBundle.field_groupId, "capture")) || ((!bs.isNullOrNil(paramBundle.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XQ(paramBundle.field_groupId))))
    {
      v(paramBundle);
      AppMethodBeat.o(108843);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.emoji.f.g(paramBundle.field_groupId, (byte)0);
    com.tencent.mm.kernel.g.agQ().ghe.a(paramBundle, 0);
    AppMethodBeat.o(108843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108844);
    com.tencent.mm.kernel.g.agQ().ghe.b(423, this);
    ap.aB(this.peR);
    super.onDestroy();
    this.peQ.dead();
    if (this.peN != null) {
      this.peN.fWx = null;
    }
    AppMethodBeat.o(108844);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(108845);
    if (paramn.getType() == 423)
    {
      if (!(paramn instanceof com.tencent.mm.plugin.emoji.f.g))
      {
        AppMethodBeat.o(108845);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.f.g)paramn;
      if ((paramString != null) && (!bs.isNullOrNil(paramString.pbW)) && (this.peL != null) && (!bs.isNullOrNil(this.peL.field_groupId)) && (this.peL.field_groupId.equalsIgnoreCase(paramString.pbW)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          v(this.peL);
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 4)
        {
          cdf();
          if (this.mScene == 0)
          {
            paramString = this.peL.field_groupId;
            if (!isFinishing())
            {
              this.peP = com.tencent.mm.ui.base.h.c(this, getString(2131758208), "", true);
              this.peP.b(2131755691, new EmojiAddCustomDialogUI.4(this));
              this.peP.a(2131758210, new EmojiAddCustomDialogUI.5(this, paramString));
            }
            AppMethodBeat.o(108845);
            return;
          }
          Ys(getString(2131758208));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 8)
        {
          cdf();
          Ys(getString(2131758207));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 9)
        {
          cdf();
          Ys(getString(2131758206));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == -2)
        {
          cdf();
          Ys(getString(2131758209));
          AppMethodBeat.o(108845);
          return;
        }
        cdf();
        Ys(getString(2131758205));
        AppMethodBeat.o(108845);
        return;
      }
      ac.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
    }
    AppMethodBeat.o(108845);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI
 * JD-Core Version:    0.7.0.1
 */