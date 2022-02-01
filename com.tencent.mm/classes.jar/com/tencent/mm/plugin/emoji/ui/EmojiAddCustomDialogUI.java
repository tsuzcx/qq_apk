package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ch.a.b;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.d.d.a;
import com.tencent.mm.f.a.dt;
import com.tencent.mm.f.a.dt.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.tools.b.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiAddCustomDialogUI
  extends MMBaseActivity
  implements i
{
  private Context mContext;
  private ProgressDialog mRa;
  private int mScene;
  private String ovC;
  private boolean sCE;
  private boolean uIA;
  private com.tencent.mm.emoji.d.d uIB;
  private com.tencent.mm.ui.widget.a.d uIC;
  private com.tencent.mm.ui.widget.a.d uID;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> uIE;
  private Runnable uIF;
  private String uIy;
  private EmojiInfo uIz;
  
  public EmojiAddCustomDialogUI()
  {
    AppMethodBeat.i(108842);
    this.uIF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108829);
        EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(i.h.emoji_store_watting_add));
        AppMethodBeat.o(108829);
      }
    };
    AppMethodBeat.o(108842);
  }
  
  private void auQ(String paramString)
  {
    AppMethodBeat.i(108849);
    if (isFinishing())
    {
      AppMethodBeat.o(108849);
      return;
    }
    this.uID = com.tencent.mm.ui.base.h.c(this, paramString, "", true);
    this.uID.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(258312);
        EmojiAddCustomDialogUI.this.setResult(1);
        EmojiAddCustomDialogUI.this.finish();
        AppMethodBeat.o(258312);
      }
    });
    AppMethodBeat.o(108849);
  }
  
  private static void cVP()
  {
    AppMethodBeat.i(108846);
    Object localObject = new dt();
    ((dt)localObject).fzk.type = 1;
    EventCenter.instance.publish((IEvent)localObject);
    if (!((dt)localObject).fzl.fzm)
    {
      localObject = p.getEmojiStorageMgr().VFK.hBK();
      if (localObject != null)
      {
        Iterator localIterator = ((eiv)localObject).UkP.iterator();
        while (localIterator.hasNext())
        {
          eiw localeiw = (eiw)localIterator.next();
          if (localeiw.ProductID.equals(String.valueOf(EmojiGroupInfo.YCv))) {
            localeiw.CqR = 0;
          }
        }
      }
      p.getEmojiStorageMgr().VFK.a((eiv)localObject);
      com.tencent.mm.ch.a.hqW();
      localObject = com.tencent.mm.ch.a.UQl;
      a.b.btV(String.valueOf(EmojiGroupInfo.YCv));
    }
    AppMethodBeat.o(108846);
  }
  
  private void cVQ()
  {
    AppMethodBeat.i(108848);
    if (isFinishing())
    {
      AppMethodBeat.o(108848);
      return;
    }
    this.uIC = com.tencent.mm.ui.base.h.a(this.mContext, i.h.emoji_upper_limit_warning, i.h.app_empty_string, i.h.emoji_store_mgr_alert, i.h.app_cancel, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(258273);
        Object localObject = new Intent();
        com.tencent.mm.plugin.report.service.h.IzE.a(11596, new Object[] { Integer.valueOf(3) });
        ((Intent)localObject).setClass(EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this), EmojiCustomUI.class);
        ((Intent)localObject).putExtra("key_emoji_panel_type", 0);
        paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(258273);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(108840);
        EmojiAddCustomDialogUI.this.setResult(3);
        EmojiAddCustomDialogUI.this.finish();
        AppMethodBeat.o(108840);
      }
    });
    if (this.uIC != null) {
      this.uIC.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(257977);
          EmojiAddCustomDialogUI.this.setResult(3);
          EmojiAddCustomDialogUI.this.finish();
          AppMethodBeat.o(257977);
        }
      });
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
    paramEmojiInfo.lBH = true;
    paramEmojiInfo.bhW().a(this.uIE).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(c.a<ia> paramAnonymousa)
      {
        AppMethodBeat.i(255705);
        int i = paramAnonymousa.errType;
        int j = paramAnonymousa.errCode;
        if (j == -434)
        {
          Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgN, Boolean.TRUE);
          EmojiAddCustomDialogUI.this.cVG();
          EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
          com.tencent.mm.plugin.report.service.h.IzE.a(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.c(EmojiAddCustomDialogUI.this)), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).getMd5(), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_designerID, EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_size), EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_activityid });
        }
        for (;;)
        {
          paramAnonymousa = YAb;
          AppMethodBeat.o(255705);
          return paramAnonymousa;
          if ((i == 0) && (j == 0))
          {
            Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
            paramAnonymousa = (ia)paramAnonymousa.lBJ;
            if ((paramAnonymousa != null) && (paramAnonymousa.RNu != null) && (paramAnonymousa.RNu.size() > 0))
            {
              Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramAnonymousa.RNu.size()) });
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
  
  protected final void cVG()
  {
    AppMethodBeat.i(108850);
    MMHandlerThread.removeRunnable(this.uIF);
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
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
    this.uIE = new com.tencent.mm.vending.e.c();
    this.ovC = getIntent().getStringExtra("extra_id");
    this.mScene = getIntent().getIntExtra("extra_scence", -1);
    this.uIy = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.uIy == null)) {
      this.uIy = z.bcZ();
    }
    this.sCE = getIntent().getBooleanExtra("extra_move_to_top", true);
    this.uIA = getIntent().getBooleanExtra("key_is_selfie", false);
    if (Util.isNullOrNil(this.ovC))
    {
      Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.uIz = p.getEmojiStorageMgr().VFH.bxK(this.ovC);
    com.tencent.mm.kernel.h.aHF().kcd.a(423, this);
    MMHandlerThread.postToMainThreadDelayed(this.uIF, 300L);
    Object localObject = this.mContext;
    paramBundle = this.uIz;
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
    localObject = l.jIq;
    if (l.getKV().getBoolean("custom_full", false))
    {
      Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      cVG();
      cVQ();
      com.tencent.mm.plugin.report.service.h.IzE.a(10431, new Object[] { Integer.valueOf(this.mScene), this.uIz.getMd5(), this.uIz.field_designerID, this.uIz.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.uIz.field_size), this.uIy, this.uIz.field_activityid });
      AppMethodBeat.o(108843);
      return;
    }
    if ((paramBundle.field_catalog == EmojiInfo.YCD) || (Util.isNullOrNil(paramBundle.field_groupId)) || (Util.isEqual(paramBundle.field_groupId, "capture")) || ((!Util.isNullOrNil(paramBundle.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aui(paramBundle.field_groupId))))
    {
      v(paramBundle);
      AppMethodBeat.o(108843);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.emoji.f.h(paramBundle.field_groupId, (byte)0);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramBundle, 0);
    AppMethodBeat.o(108843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108844);
    com.tencent.mm.kernel.h.aHF().kcd.b(423, this);
    MMHandlerThread.removeRunnable(this.uIF);
    super.onDestroy();
    this.uIE.dead();
    if (this.uIB != null) {
      this.uIB.jPl = null;
    }
    AppMethodBeat.o(108844);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(108845);
    if (paramq.getType() == 423)
    {
      if (!(paramq instanceof com.tencent.mm.plugin.emoji.f.h))
      {
        AppMethodBeat.o(108845);
        return;
      }
      paramString = (com.tencent.mm.plugin.emoji.f.h)paramq;
      if ((paramString != null) && (!Util.isNullOrNil(paramString.uFI)) && (this.uIz != null) && (!Util.isNullOrNil(this.uIz.field_groupId)) && (this.uIz.field_groupId.equalsIgnoreCase(paramString.uFI)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          v(this.uIz);
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 4)
        {
          cVG();
          if (this.mScene == 0)
          {
            paramString = this.uIz.field_groupId;
            if (!isFinishing())
            {
              this.uID = com.tencent.mm.ui.base.h.c(this, getString(i.h.emoji_add_failed_no_play), "", true);
              this.uID.b(i.h.app_cancel, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(258447);
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(258447);
                }
              });
              this.uID.a(i.h.emoji_add_fialed_non_purchase_goto, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(255459);
                  Object localObject = new Intent();
                  ((Intent)localObject).setClass(EmojiAddCustomDialogUI.this, EmojiStoreDetailUI.class);
                  ((Intent)localObject).putExtra("extra_id", paramString);
                  ((Intent)localObject).putExtra("preceding_scence", 20);
                  paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(255459);
                }
              });
            }
            AppMethodBeat.o(108845);
            return;
          }
          auQ(getString(i.h.emoji_add_failed_no_play));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 8)
        {
          cVG();
          auQ(getString(i.h.emoji_add_failed_no_area));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 9)
        {
          cVG();
          auQ(getString(i.h.emoji_add_failed_expired));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == -2)
        {
          cVG();
          auQ(getString(i.h.emoji_add_failed_no_try));
          AppMethodBeat.o(108845);
          return;
        }
        cVG();
        auQ(getString(i.h.emoji_add_failed));
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