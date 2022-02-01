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
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.emoji.d.d.a;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.protocal.protobuf.il;
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
  private ProgressDialog jZH;
  private String lAl;
  private Context mContext;
  private int mScene;
  private boolean pto;
  private String rfp;
  private EmojiInfo rfq;
  private boolean rfr;
  private com.tencent.mm.emoji.d.d rfs;
  private com.tencent.mm.ui.widget.a.d rft;
  private com.tencent.mm.ui.widget.a.d rfu;
  private com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> rfv;
  private Runnable rfw;
  
  public EmojiAddCustomDialogUI()
  {
    AppMethodBeat.i(108842);
    this.rfw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(108829);
        EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(2131758683));
        AppMethodBeat.o(108829);
      }
    };
    AppMethodBeat.o(108842);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(108849);
    if (isFinishing())
    {
      AppMethodBeat.o(108849);
      return;
    }
    this.rfu = com.tencent.mm.ui.base.h.c(this, paramString, "", true);
    this.rfu.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(240158);
        EmojiAddCustomDialogUI.this.setResult(1);
        EmojiAddCustomDialogUI.this.finish();
        AppMethodBeat.o(240158);
      }
    });
    AppMethodBeat.o(108849);
  }
  
  private static void cHd()
  {
    AppMethodBeat.i(108846);
    Object localObject = new do();
    ((do)localObject).dGz.type = 1;
    EventCenter.instance.publish((IEvent)localObject);
    if (!((do)localObject).dGA.dGB)
    {
      localObject = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.gFr();
      if (localObject != null)
      {
        Iterator localIterator = ((dyv)localObject).MYx.iterator();
        while (localIterator.hasNext())
        {
          dyw localdyw = (dyw)localIterator.next();
          if (localdyw.ProductID.equals(String.valueOf(EmojiGroupInfo.Uun))) {
            localdyw.xuA = 0;
          }
        }
      }
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpQ.a((dyv)localObject);
      com.tencent.mm.ca.a.gvc();
      localObject = com.tencent.mm.ca.a.NCN;
      a.b.bhD(String.valueOf(EmojiGroupInfo.Uun));
    }
    AppMethodBeat.o(108846);
  }
  
  private void cHe()
  {
    AppMethodBeat.i(108848);
    if (isFinishing())
    {
      AppMethodBeat.o(108848);
      return;
    }
    this.rft = com.tencent.mm.ui.base.h.a(this.mContext, 2131758707, 2131755797, 2131758631, 2131755761, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(240168);
        Object localObject = new Intent();
        com.tencent.mm.plugin.report.service.h.CyF.a(11596, new Object[] { Integer.valueOf(3) });
        ((Intent)localObject).setClass(EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this), EmojiCustomUI.class);
        ((Intent)localObject).putExtra("key_emoji_panel_type", 0);
        paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(240168);
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
    if (this.rft != null) {
      this.rft.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(240169);
          EmojiAddCustomDialogUI.this.setResult(3);
          EmojiAddCustomDialogUI.this.finish();
          AppMethodBeat.o(240169);
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
    paramEmojiInfo = new com.tencent.mm.emoji.sync.a(0, localArrayList);
    paramEmojiInfo.iLA = true;
    paramEmojiInfo.aYI().a(this.rfv).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(c.a<il> paramAnonymousa)
      {
        AppMethodBeat.i(240163);
        int i = paramAnonymousa.errType;
        int j = paramAnonymousa.errCode;
        if (j == -434)
        {
          Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
          paramAnonymousa = com.tencent.mm.emoji.b.k.gXr;
          com.tencent.mm.emoji.b.k.dZ(true);
          g.aAh().azQ().set(ar.a.NSP, Boolean.TRUE);
          EmojiAddCustomDialogUI.this.cGW();
          EmojiAddCustomDialogUI.b(EmojiAddCustomDialogUI.this);
          com.tencent.mm.plugin.report.service.h.CyF.a(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.c(EmojiAddCustomDialogUI.this)), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).getMd5(), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_designerID, EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_size), EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this), EmojiAddCustomDialogUI.d(EmojiAddCustomDialogUI.this).field_activityid });
        }
        for (;;)
        {
          paramAnonymousa = QZL;
          AppMethodBeat.o(240163);
          return paramAnonymousa;
          if ((i == 0) && (j == 0))
          {
            Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
            paramAnonymousa = (il)paramAnonymousa.iLC;
            if ((paramAnonymousa != null) && (paramAnonymousa.KMA != null) && (paramAnonymousa.KMA.size() > 0))
            {
              Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[] { Integer.valueOf(paramAnonymousa.KMA.size()) });
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
  
  protected final void cGW()
  {
    AppMethodBeat.i(108850);
    MMHandlerThread.removeRunnable(this.rfw);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
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
    this.rfv = new com.tencent.mm.vending.e.c();
    this.lAl = getIntent().getStringExtra("extra_id");
    this.mScene = getIntent().getIntExtra("extra_scence", -1);
    this.rfp = getIntent().getStringExtra("extra_username");
    if ((getIntent().getBooleanExtra("extra_current", false)) && (this.rfp == null)) {
      this.rfp = z.aTY();
    }
    this.pto = getIntent().getBooleanExtra("extra_move_to_top", true);
    this.rfr = getIntent().getBooleanExtra("key_is_selfie", false);
    if (Util.isNullOrNil(this.lAl))
    {
      Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
      setResult(1);
      finish();
    }
    this.rfq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(this.lAl);
    g.aAg().hqi.a(423, this);
    MMHandlerThread.postToMainThreadDelayed(this.rfw, 300L);
    Object localObject = this.mContext;
    paramBundle = this.rfq;
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
    localObject = com.tencent.mm.emoji.b.k.gXr;
    if (com.tencent.mm.emoji.b.k.getKV().getBoolean("custom_full", false))
    {
      Log.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      cGW();
      cHe();
      com.tencent.mm.plugin.report.service.h.CyF.a(10431, new Object[] { Integer.valueOf(this.mScene), this.rfq.getMd5(), this.rfq.field_designerID, this.rfq.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.rfq.field_size), this.rfp, this.rfq.field_activityid });
      AppMethodBeat.o(108843);
      return;
    }
    if ((paramBundle.field_catalog == EmojiInfo.Uuv) || (Util.isNullOrNil(paramBundle.field_groupId)) || (Util.isEqual(paramBundle.field_groupId, "capture")) || ((!Util.isNullOrNil(paramBundle.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amq(paramBundle.field_groupId))))
    {
      v(paramBundle);
      AppMethodBeat.o(108843);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.emoji.f.h(paramBundle.field_groupId, (byte)0);
    g.aAg().hqi.a(paramBundle, 0);
    AppMethodBeat.o(108843);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108844);
    g.aAg().hqi.b(423, this);
    MMHandlerThread.removeRunnable(this.rfw);
    super.onDestroy();
    this.rfv.dead();
    if (this.rfs != null) {
      this.rfs.hdF = null;
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
      if ((paramString != null) && (!Util.isNullOrNil(paramString.rcD)) && (this.rfq != null) && (!Util.isNullOrNil(this.rfq.field_groupId)) && (this.rfq.field_groupId.equalsIgnoreCase(paramString.rcD)))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          v(this.rfq);
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 4)
        {
          cGW();
          if (this.mScene == 0)
          {
            paramString = this.rfq.field_groupId;
            if (!isFinishing())
            {
              this.rfu = com.tencent.mm.ui.base.h.c(this, getString(2131758496), "", true);
              this.rfu.b(2131755761, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(240159);
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(240159);
                }
              });
              this.rfu.a(2131758498, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(240160);
                  Object localObject = new Intent();
                  ((Intent)localObject).setClass(EmojiAddCustomDialogUI.this, EmojiStoreDetailUI.class);
                  ((Intent)localObject).putExtra("extra_id", paramString);
                  ((Intent)localObject).putExtra("preceding_scence", 20);
                  paramAnonymousDialogInterface = EmojiAddCustomDialogUI.this;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emoji/ui/EmojiAddCustomDialogUI$13", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  EmojiAddCustomDialogUI.this.finish();
                  AppMethodBeat.o(240160);
                }
              });
            }
            AppMethodBeat.o(108845);
            return;
          }
          amW(getString(2131758496));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 8)
        {
          cGW();
          amW(getString(2131758495));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == 9)
        {
          cGW();
          amW(getString(2131758494));
          AppMethodBeat.o(108845);
          return;
        }
        if (paramInt2 == -2)
        {
          cGW();
          amW(getString(2131758497));
          AppMethodBeat.o(108845);
          return;
        }
        cGW();
        amW(getString(2131758493));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI
 * JD-Core Version:    0.7.0.1
 */