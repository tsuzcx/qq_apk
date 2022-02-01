package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.to;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d.a;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.i.a;
import com.tencent.mm.plugin.card.b.j.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardDetailUI
  extends MMActivity
  implements com.tencent.mm.ak.f, c.a, d.a, j.a, bi.a
{
  private View GG;
  private final String TAG;
  private float fHj;
  private float fHk;
  private b.a fHp;
  private int fRv;
  private p fSP;
  private String hDH;
  private com.tencent.mm.modelgeo.d hTg;
  aq mHandler;
  private long mStartTime;
  private Vibrator nQa;
  private String oCY;
  private com.tencent.mm.plugin.card.base.b oDm;
  private ArrayList<tn> oDt;
  private String oEk;
  private boolean oEy;
  private int oIS;
  private boolean oJf;
  private int oKU;
  private String oKV;
  private String oKW;
  private String oKX;
  private boolean oKb;
  private String oLA;
  private com.tencent.mm.plugin.card.b.i oLB;
  e oLn;
  private String oLo;
  private String oLp;
  private String oLq;
  private boolean oLr;
  private boolean oLs;
  private boolean oLt;
  private String oLu;
  private e.a oLv;
  private boolean oLw;
  private boolean oLx;
  private boolean oLy;
  private boolean oLz;
  
  public CardDetailUI()
  {
    AppMethodBeat.i(113213);
    this.TAG = "MicroMsg.CardDetailUI";
    this.fSP = null;
    this.oCY = "";
    this.oEk = "";
    this.oLo = "";
    this.oLp = "";
    this.oLq = "";
    this.oKV = "";
    this.oKW = "";
    this.oKX = "";
    this.oEy = false;
    this.oLr = false;
    this.oLs = false;
    this.oLt = false;
    this.hDH = "";
    this.oLu = "";
    this.oJf = false;
    this.mHandler = new aq();
    this.fRv = 3;
    this.oKU = 0;
    this.oIS = -1;
    this.oLw = false;
    this.oLx = true;
    this.mStartTime = 0L;
    this.oLy = false;
    this.oKb = false;
    this.oLz = false;
    this.fHj = -85.0F;
    this.fHk = -1000.0F;
    this.oLA = "";
    this.oLB = new com.tencent.mm.plugin.card.b.i();
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(113199);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(113199);
          return true;
        }
        if ((CardDetailUI.a(CardDetailUI.this) == -85.0F) && (CardDetailUI.b(CardDetailUI.this) == -1000.0F))
        {
          CardDetailUI.a(CardDetailUI.this, paramAnonymousFloat2);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousFloat1);
          am.bWi().N(CardDetailUI.a(CardDetailUI.this), CardDetailUI.b(CardDetailUI.this));
        }
        com.tencent.mm.plugin.card.b.i locali = CardDetailUI.c(CardDetailUI.this);
        paramAnonymousFloat1 = CardDetailUI.b(CardDetailUI.this);
        paramAnonymousFloat2 = CardDetailUI.a(CardDetailUI.this);
        synchronized (locali.djX)
        {
          locali.fHj = paramAnonymousFloat2;
          locali.fHk = paramAnonymousFloat1;
          if (CardDetailUI.d(CardDetailUI.this))
          {
            CardDetailUI.e(CardDetailUI.this);
            CardDetailUI.f(CardDetailUI.this);
          }
          CardDetailUI.g(CardDetailUI.this);
          AppMethodBeat.o(113199);
          return false;
        }
      }
    };
    AppMethodBeat.o(113213);
  }
  
  private void A(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(113233);
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.oLA);
      localIntent.putExtra("key_card_id", this.oCY);
      localIntent.putExtra("key_finish_action", paramInt);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.oIS == 7) || (this.oIS == 8) || (this.oIS == 16) || (this.oIS == 26)) && (this.fRv == 3))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.oLA);
      if (paramInt > 0)
      {
        localIntent.putExtra("key_card_id", this.oCY);
        localIntent.putExtra("key_finish_action", paramInt);
      }
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.oIS == 7) && (this.fRv == 7)) || ((this.oIS == 16) && (this.fRv == 16)) || ((this.oIS == 8) && (this.fRv == 8)) || ((this.oIS == 26) && (this.fRv == 26)))
    {
      setResult(0);
      if (paramBoolean)
      {
        finish();
        AppMethodBeat.o(113233);
      }
    }
    else if (paramBoolean)
    {
      finish();
    }
    AppMethodBeat.o(113233);
  }
  
  private void AM(int paramInt)
  {
    AppMethodBeat.i(113234);
    if ((this.oIS != 7) && (this.oIS != 16))
    {
      ae.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      AppMethodBeat.o(113234);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).oEo = this.oDm.bVh();
    ((com.tencent.mm.plugin.card.model.e)localObject).dJc = this.oLq;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.oLA;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.g.a.b();
    ((com.tencent.mm.g.a.b)localObject).dkC.bZU = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.g.a.b)localObject).dkC.dkD = com.tencent.mm.plugin.card.d.h.a(localLinkedList, true, this.oIS);; ((com.tencent.mm.g.a.b)localObject).dkC.dkD = com.tencent.mm.plugin.card.d.h.a(localLinkedList, false, this.oIS))
    {
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(113234);
      return;
    }
  }
  
  /* Error */
  private void YW(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 270
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:oJf	Z
    //   12: ifeq +20 -> 32
    //   15: ldc 91
    //   17: ldc_w 272
    //   20: invokestatic 275	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 270
    //   26: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: ldc 91
    //   34: ldc_w 277
    //   37: invokestatic 209	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 127	com/tencent/mm/plugin/card/ui/CardDetailUI:oJf	Z
    //   45: new 177	android/content/Intent
    //   48: dup
    //   49: aload_0
    //   50: ldc_w 279
    //   53: invokespecial 282	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   56: astore_2
    //   57: aload_2
    //   58: ldc_w 284
    //   61: aload_0
    //   62: getfield 217	com/tencent/mm/plugin/card/ui/CardDetailUI:oDm	Lcom/tencent/mm/plugin/card/base/b;
    //   65: invokeinterface 287 1 0
    //   70: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   73: pop
    //   74: aload_2
    //   75: ldc_w 289
    //   78: aload_1
    //   79: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_2
    //   84: ldc_w 291
    //   87: aload_0
    //   88: getfield 217	com/tencent/mm/plugin/card/ui/CardDetailUI:oDm	Lcom/tencent/mm/plugin/card/base/b;
    //   91: invokeinterface 295 1 0
    //   96: getfield 300	com/tencent/mm/protocal/protobuf/tu:hDr	Ljava/lang/String;
    //   99: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   102: pop
    //   103: aload_2
    //   104: ldc_w 302
    //   107: aload_0
    //   108: getfield 134	com/tencent/mm/plugin/card/ui/CardDetailUI:fRv	I
    //   111: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload_2
    //   116: ldc_w 304
    //   119: iconst_0
    //   120: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   123: pop
    //   124: new 306	com/tencent/mm/hellhoundlib/b/a
    //   127: dup
    //   128: invokespecial 307	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 311	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   135: astore_1
    //   136: aload_0
    //   137: aload_1
    //   138: invokevirtual 315	com/tencent/mm/hellhoundlib/b/a:ahE	()[Ljava/lang/Object;
    //   141: ldc_w 316
    //   144: ldc_w 318
    //   147: ldc_w 319
    //   150: ldc_w 321
    //   153: ldc_w 323
    //   156: ldc_w 325
    //   159: invokestatic 330	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: aload_1
    //   164: iconst_0
    //   165: invokevirtual 334	com/tencent/mm/hellhoundlib/b/a:mt	(I)Ljava/lang/Object;
    //   168: checkcast 177	android/content/Intent
    //   171: invokevirtual 336	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   174: aload_0
    //   175: ldc_w 316
    //   178: ldc_w 318
    //   181: ldc_w 319
    //   184: ldc_w 321
    //   187: ldc_w 323
    //   190: ldc_w 325
    //   193: invokestatic 339	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   196: ldc_w 270
    //   199: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: goto -173 -> 29
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	CardDetailUI
    //   0	210	1	paramString	String
    //   56	76	2	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	29	205	finally
    //   32	202	205	finally
  }
  
  private void a(j.b paramb)
  {
    AppMethodBeat.i(113247);
    if (this.oLn.dus)
    {
      ae.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      AppMethodBeat.o(113247);
      return;
    }
    ae.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.oLn.a(this.oLt, paramb, true);
    AppMethodBeat.o(113247);
  }
  
  private void bUB()
  {
    AppMethodBeat.i(113236);
    if (this.hTg != null) {
      this.hTg.c(this.fHp);
    }
    AppMethodBeat.o(113236);
  }
  
  private void bUz()
  {
    AppMethodBeat.i(113235);
    if (this.hTg == null) {
      this.hTg = com.tencent.mm.modelgeo.d.aIh();
    }
    this.hTg.a(this.fHp, true);
    AppMethodBeat.o(113235);
  }
  
  private void bWN()
  {
    AppMethodBeat.i(113224);
    this.oLv.fRv = this.fRv;
    this.oLv.oIS = this.oIS;
    this.oLv.oCY = this.oCY;
    this.oLn.a(this.oDm, this.oLv, this.oDt);
    this.oLn.bWN();
    am.bWn().oDm = this.oDm;
    AppMethodBeat.o(113224);
  }
  
  private void bWX()
  {
    AppMethodBeat.i(113237);
    this.hTg = com.tencent.mm.modelgeo.d.aIh();
    bUz();
    AppMethodBeat.o(113237);
  }
  
  private void bXn()
  {
    AppMethodBeat.i(113219);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1057, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1037, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1058, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1045, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1077, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1099, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(902, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1051, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(1163, this);
    AppMethodBeat.o(113219);
  }
  
  private void bXo()
  {
    AppMethodBeat.i(113220);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1057, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1037, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1058, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1045, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1077, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1099, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(902, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1051, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(1163, this);
    AppMethodBeat.o(113220);
  }
  
  private void bXp()
  {
    AppMethodBeat.i(113222);
    this.oIS = this.fRv;
    this.oLv = new e.a();
    this.oLv.fRv = this.fRv;
    this.oLv.oIS = this.oIS;
    this.oLv.oCY = this.oCY;
    this.oLv.oLo = this.oLo;
    this.oLv.oLq = this.oLq;
    this.oLv.oLp = this.oLp;
    this.oLv.oKV = this.oKV;
    this.oLv.oKW = this.oKW;
    this.oLv.oEy = this.oEy;
    this.oLv.oMm = getIntent().getIntExtra("key_from_appbrand_type", 0);
    AppMethodBeat.o(113222);
  }
  
  private void bXq()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113223);
    if ((this.oLy) || (this.oDm == null))
    {
      AppMethodBeat.o(113223);
      return;
    }
    this.oLy = true;
    if (this.oEy)
    {
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      j = this.oDm.bVc().mwj;
      str1 = this.oDm.bVh();
      str2 = this.oDm.bVg();
      k = this.oIS;
      str3 = this.oLo;
      if (this.oDm.bVa()) {}
      for (;;)
      {
        localg.f(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        AppMethodBeat.o(113223);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
    int k = this.oDm.bVc().mwj;
    String str1 = this.oDm.bVh();
    String str2 = this.oDm.bVg();
    int m = this.oIS;
    String str3 = this.oLo;
    if (this.oDm.bVa()) {}
    for (i = j;; i = 0)
    {
      localg.f(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      AppMethodBeat.o(113223);
      return;
    }
  }
  
  private void bXr()
  {
    AppMethodBeat.i(113229);
    Object localObject = new diy();
    ((diy)localObject).HQD = this.hDH;
    ((diy)localObject).oFI = this.oLu;
    ae.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.hDH });
    localObject = new aa(this.oCY, this.fRv, this.oLo, this.oLq, this.oKV, this.oKW, this.oKU, this.oKX, (diy)localObject);
    com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject, 0);
    AppMethodBeat.o(113229);
  }
  
  private void bXs()
  {
    AppMethodBeat.i(113230);
    Object localObject;
    if (!TextUtils.isEmpty(this.oDm.bVh())) {
      localObject = this.oDm.bVh();
    }
    while ((this.oDm != null) && (this.oDm.bVc().Gkc == 1))
    {
      float f2 = this.fHj;
      float f3 = this.fHk;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.bWi().fHj;
        f1 = am.bWi().fHk;
      }
      localObject = new com.tencent.mm.plugin.card.model.v((String)localObject, f1, f2, this.oDm.bVg());
      com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject, 0);
      AppMethodBeat.o(113230);
      return;
      if (!TextUtils.isEmpty(this.oCY))
      {
        localObject = this.oCY;
      }
      else
      {
        ae.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
        AppMethodBeat.o(113230);
        return;
      }
    }
    if ((this.oDm != null) && (this.oDm.bVc().Gkc > 1))
    {
      if ((this.fHj != -85.0F) && (this.fHk != -1000.0F))
      {
        this.oLz = false;
        localObject = new com.tencent.mm.plugin.card.model.v((String)localObject, this.fHk, this.fHj, this.oDm.bVg());
        com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject, 0);
        AppMethodBeat.o(113230);
        return;
      }
      if (!this.oLz)
      {
        this.oLz = true;
        if (this.oKb)
        {
          bUz();
          AppMethodBeat.o(113230);
        }
      }
    }
    else if (this.oDm != null)
    {
      this.oDm.a(null);
      bWN();
      if (this.oDm.bUI())
      {
        localObject = am.bWk().Zv(this.oCY);
        if (localObject != null)
        {
          ((ShareCardInfo)localObject).a(null);
          am.bWk().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.oCY });
        }
        AppMethodBeat.o(113230);
        return;
      }
      localObject = am.bWc().Zf(this.oCY);
      if (localObject != null)
      {
        ((CardInfo)localObject).a(null);
        am.bWc().update((com.tencent.mm.sdk.e.c)localObject, new String[] { this.oCY });
      }
    }
    AppMethodBeat.o(113230);
  }
  
  private void bXt()
  {
    AppMethodBeat.i(113231);
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.oCY);
    com.tencent.mm.kernel.g.ajQ().gDv.a(localc, 0);
    AppMethodBeat.o(113231);
  }
  
  private void c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(113226);
    ae.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + paramInt1 + " errMsg = " + paramString1 + " ret_code:" + paramInt2 + " ret_msg:" + paramString2);
    if (paramInt2 == 10000)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = getString(2131756791);
      }
      this.oDm.bVd().status = 4;
      bWN();
    }
    for (;;)
    {
      com.tencent.mm.plugin.card.d.d.c(this, paramString1);
      AppMethodBeat.o(113226);
      return;
      if (paramInt2 == 10001)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756795);
        }
        this.oDm.bVd().status = 5;
        bWN();
      }
      else if (paramInt2 == 10002)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756946);
        }
      }
      else
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(2131756789);
        }
      }
    }
  }
  
  private void js(boolean paramBoolean)
  {
    AppMethodBeat.i(113227);
    if (paramBoolean)
    {
      this.fSP = p.a(this, getString(2131760709), true, 0, null);
      AppMethodBeat.o(113227);
      return;
    }
    if ((this.fSP != null) && (this.fSP.isShowing()))
    {
      this.fSP.dismiss();
      this.fSP = null;
    }
    AppMethodBeat.o(113227);
  }
  
  private void ju(boolean paramBoolean)
  {
    AppMethodBeat.i(113228);
    if (paramBoolean) {
      com.tencent.mm.plugin.card.d.l.fk(this.oLn.oMb, this.oLn.oMa);
    }
    AppMethodBeat.o(113228);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(218592);
    paramString = this.oLn.oLL;
    if (paramString != null) {
      paramString.bZK();
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(16827, new Object[] { this.oCY, Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(218592);
  }
  
  public final void YU(String paramString)
  {
    AppMethodBeat.i(113249);
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.d.d.a(this, paramString, true);
    }
    AppMethodBeat.o(113249);
  }
  
  public final void YX(final String paramString)
  {
    AppMethodBeat.i(113243);
    if (!this.oLn.bXY())
    {
      ae.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
      AppMethodBeat.o(113243);
      return;
    }
    ae.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(113212);
        CardDetailUI.c(CardDetailUI.this, paramString);
        AppMethodBeat.o(113212);
      }
    });
    AppMethodBeat.o(113243);
  }
  
  public final void Za(String paramString)
  {
    AppMethodBeat.i(113246);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.oCY)))
    {
      ae.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113246);
      return;
    }
    this.oLr = false;
    AppMethodBeat.o(113246);
  }
  
  public final void b(String paramString, j.b paramb)
  {
    AppMethodBeat.i(113244);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.oCY)))
    {
      ae.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113244);
      return;
    }
    js(false);
    ae.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
    ae.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.oEc + " markCardId: " + paramb.oEd);
    this.oLs = false;
    if (paramb.oEc == 1)
    {
      if ((!TextUtils.isEmpty(paramb.oEd)) && (!this.oDm.bVg().equals(paramb.oEd)))
      {
        ae.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
        if (this.oDm.bUI())
        {
          paramString = am.bWk().Zv(paramb.oEd);
          if (paramString != null)
          {
            this.oDm = paramString;
            this.oCY = paramb.oEd;
            bWN();
            am.bWn().b(this.oDm);
            ae.i("MicroMsg.CardDetailUI", "update the mCardInfo");
            this.oLr = true;
            a(paramb);
            AppMethodBeat.o(113244);
            return;
          }
          ae.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756926));
          this.oLr = false;
          AppMethodBeat.o(113244);
        }
      }
      else
      {
        ae.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
        this.oLr = true;
        a(paramb);
        AppMethodBeat.o(113244);
      }
    }
    else
    {
      this.oLr = false;
      com.tencent.mm.plugin.card.d.d.c(this, getString(2131756927));
    }
    AppMethodBeat.o(113244);
  }
  
  public final void bVB()
  {
    AppMethodBeat.i(113241);
    ae.i("MicroMsg.CardDetailUI", "onVibrate");
    this.nQa.vibrate(300L);
    AppMethodBeat.o(113241);
  }
  
  public final void bVC()
  {
    AppMethodBeat.i(113242);
    ae.i("MicroMsg.CardDetailUI", "onFinishUI");
    AppMethodBeat.o(113242);
  }
  
  public final void bVw()
  {
    AppMethodBeat.i(113248);
    ae.i("MicroMsg.CardDetailUI", "code change");
    if ((this.oLn.oLL instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.oLn.oLL).oQb = am.bWp().getCode();
      this.oLn.bWN();
    }
    AppMethodBeat.o(113248);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113240);
    if (paramb == null)
    {
      ae.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if ((this.oDm == null) || (!this.oDm.bVg().equals(paramb.bVg())))
    {
      ae.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if (!this.oLn.bXY())
    {
      ae.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    ae.i("MicroMsg.CardDetailUI", "onDataChange");
    this.oDm = paramb;
    this.oCY = this.oDm.bVg();
    if ((this.oDm.bUW()) && (am.bWp().isEmpty())) {
      am.bWp().YV(this.oDm.bVg());
    }
    bWN();
    AppMethodBeat.o(113240);
  }
  
  public final void eZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113245);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.oCY)))
    {
      ae.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113245);
      return;
    }
    ae.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.oLr = false;
    this.oLs = false;
    js(false);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(2131756926);
    }
    com.tencent.mm.plugin.card.d.d.c(this, paramString1);
    AppMethodBeat.o(113245);
  }
  
  public int getLayoutId()
  {
    return 2131493272;
  }
  
  public void initView()
  {
    AppMethodBeat.i(113221);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(113200);
        CardDetailUI.h(CardDetailUI.this);
        AppMethodBeat.o(113200);
        return true;
      }
    });
    this.nQa = ((Vibrator)getSystemService("vibrator"));
    this.GG = findViewById(2131297780);
    Object localObject2;
    if (this.oLn == null)
    {
      this.oLn = new e(this, getContentView());
      localObject1 = this.oLn;
      ((e)localObject1).oLX = new j(((e)localObject1).oDq);
      localObject2 = ((e)localObject1).oLX;
      ((j)localObject2).oIO = ((j)localObject2).oPS.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).jwx == null)
      {
        View localView = View.inflate(((j)localObject2).oPS, 2131493329, null);
        ((j)localObject2).jwz = localView.findViewById(2131303351);
        ((j)localObject2).jwy = ((ImageView)localView.findViewById(2131303350));
        ((j)localObject2).oPU = ((TextView)localView.findViewById(2131303353));
        ((j)localObject2).oPV = ((TextView)localView.findViewById(2131303352));
        ((j)localObject2).oPW = localView.findViewById(2131303347);
        ((j)localObject2).oPX = ((ImageView)localView.findViewById(2131303346));
        ((j)localObject2).oPY = ((MMVerticalTextView)localView.findViewById(2131306295));
        ((j)localObject2).oPZ = ((MMVerticalTextView)localView.findViewById(2131306296));
        localView.setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).jwx = new com.tencent.mm.ui.base.o(localView, -1, -1, true);
        ((j)localObject2).jwx.update();
        ((j)localObject2).jwx.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).jwx.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).oDq.setMMTitle("");
      ((e)localObject1).oDq.setActionbarColor(((e)localObject1).oDq.getResources().getColor(2131101179));
      ((e)localObject1).oLZ = new com.tencent.mm.plugin.card.b.f(((e)localObject1).oDq);
      ((e)localObject1).oDq.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      com.tencent.mm.sdk.b.a.IvT.c(((e)localObject1).oMi);
      localObject1 = this.oLn;
      if (((e)localObject1).oLF == null)
      {
        ((e)localObject1).oLF = new x();
        ((e)localObject1).oLF.a((n)localObject1);
      }
      if (((e)localObject1).oLH == null)
      {
        ((e)localObject1).oLH = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).oLH.a((n)localObject1);
      }
      if (((e)localObject1).oLI == null)
      {
        ((e)localObject1).oLI = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).oLI.a((n)localObject1);
      }
      ((e)localObject1).mListView = ((ListView)((e)localObject1).findViewById(2131297930));
      ((e)localObject1).oLM = new m(((e)localObject1).oDq.getContext());
      ((e)localObject1).oLM.oQF = ((e)localObject1).jwB;
      ((e)localObject1).mListView.setAdapter(((e)localObject1).oLM);
      ((e)localObject1).oLM.notifyDataSetChanged();
      ((e)localObject1).mListView.setOnItemClickListener(new e.1((e)localObject1));
      ae.i("MicroMsg.CardDetailUIContoller", "initMenu");
      ((e)localObject1).oDq.addIconOptionMenu(0, 2131690603, new e.5((e)localObject1));
      ((e)localObject1).oLK = ((LinearLayout)((e)localObject1).findViewById(2131300735));
      ((e)localObject1).oLV = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).oLV.a((n)localObject1);
      ((e)localObject1).oLX.oDm = ((e)localObject1).oDm;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    ae.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    int j;
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.fRv = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.d.g.ZT((String)localObject1);
      if (localObject2 != null)
      {
        this.oCY = ((com.tencent.mm.plugin.card.model.d)localObject2).dJb;
        this.oLo = ((com.tencent.mm.plugin.card.model.d)localObject2).oBM;
        this.oLq = ((com.tencent.mm.plugin.card.model.d)localObject2).dJc;
        j = ((com.tencent.mm.plugin.card.model.d)localObject2).oFH;
        ae.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + j);
        if ((j == 1) && (i == 2)) {
          this.fRv = 23;
        }
        this.oLu = ((com.tencent.mm.plugin.card.model.d)localObject2).oFI;
        ae.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.oLu);
      }
      this.oLp = com.tencent.mm.plugin.card.d.g.ZU((String)localObject1);
      bXp();
      if (!TextUtils.isEmpty(this.oCY)) {
        break label1846;
      }
      ae.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      A(true, -1);
    }
    for (;;)
    {
      this.oLn.a(this.oDm, this.oLv, this.oDt);
      this.oLn.oMf = new e.d()
      {
        public final void ZA(String paramAnonymousString)
        {
          AppMethodBeat.i(113202);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousString);
          AppMethodBeat.o(113202);
        }
        
        public final void b(com.tencent.mm.plugin.card.base.b paramAnonymousb)
        {
          AppMethodBeat.i(113207);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousb);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousb.bVg());
          CardDetailUI.m(CardDetailUI.this).oCY = CardDetailUI.n(CardDetailUI.this);
          AppMethodBeat.o(113207);
        }
        
        public final void bXt()
        {
          AppMethodBeat.i(113208);
          CardDetailUI.o(CardDetailUI.this);
          AppMethodBeat.o(113208);
        }
        
        public final void bXu()
        {
          AppMethodBeat.i(113201);
          CardDetailUI.i(CardDetailUI.this);
          AppMethodBeat.o(113201);
        }
        
        public final void bXv()
        {
          AppMethodBeat.i(113203);
          CardDetailUI.j(CardDetailUI.this);
          AppMethodBeat.o(113203);
        }
        
        public final void bXw()
        {
          AppMethodBeat.i(113204);
          CardDetailUI.k(CardDetailUI.this);
          AppMethodBeat.o(113204);
        }
        
        public final void bXx()
        {
          AppMethodBeat.i(113205);
          CardDetailUI.h(CardDetailUI.this);
          AppMethodBeat.o(113205);
        }
        
        public final void bXy()
        {
          AppMethodBeat.i(113206);
          CardDetailUI.l(CardDetailUI.this);
          AppMethodBeat.o(113206);
        }
        
        public final void bXz()
        {
          AppMethodBeat.i(113209);
          ae.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
          AppMethodBeat.o(113209);
        }
        
        public final void jv(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(113210);
          ae.i("MicroMsg.CardDetailUI", "doMark()");
          CardDetailUI.p(CardDetailUI.this);
          CardDetailUI.q(CardDetailUI.this);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousBoolean);
          if (CardDetailUI.r(CardDetailUI.this).bUV())
          {
            am.bWo().U(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.aae(CardDetailUI.r(CardDetailUI.this).bVi()), 2);
            AppMethodBeat.o(113210);
            return;
          }
          am.bWo().U(CardDetailUI.n(CardDetailUI.this), com.tencent.mm.plugin.card.d.l.aae(CardDetailUI.r(CardDetailUI.this).bVi()), 1);
          AppMethodBeat.o(113210);
        }
      };
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null);
      ae.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      this.oKb = bool;
      if (this.oKb)
      {
        this.hTg = com.tencent.mm.modelgeo.d.aIh();
        bUz();
      }
      AppMethodBeat.o(113221);
      return;
      if ((com.tencent.mm.plugin.card.d.l.Ba(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.fRv = i;
        this.oCY = getIntent().getStringExtra("key_card_id");
        this.oLq = getIntent().getStringExtra("key_card_ext");
        this.oEy = getIntent().getBooleanExtra("key_is_share_card", false);
        this.oKU = getIntent().getIntExtra("key_stastic_scene", 0);
        this.oKX = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.oKV = getIntent().getStringExtra("src_username");
          this.oKW = getIntent().getStringExtra("js_url");
          this.hDH = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.oEy) && (i == 3))
        {
          this.oEk = getIntent().getStringExtra("key_card_tp_id");
          this.oCY = com.tencent.mm.plugin.card.sharecard.a.b.fd(this.oCY, this.oEk);
          break;
        }
        if (i != 8) {
          break;
        }
        this.oLw = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.fRv = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.fRv != 26) && (this.fRv != 27)) {
          this.fRv = 3;
        }
        this.hDH = getIntent().getStringExtra("key_template_id");
        if (this.fRv == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.oDm = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.oCY = this.oDm.bVg();
            bXp();
            bXs();
            if (this.oDm.bUW()) {
              am.bWp().YV(this.oDm.bVg());
            }
            bWN();
          }
          bXq();
          com.tencent.mm.plugin.card.d.l.bZP();
        }
        else
        {
          localObject1 = getIntent().getStringExtra("card_list");
          localObject2 = getIntent().getStringExtra("key_app_id");
          localObject1 = com.tencent.mm.plugin.card.d.k.z((String)localObject1, this.fRv, (String)localObject2);
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            ae.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            A(true, -1);
          }
          for (;;)
          {
            bXp();
            break;
            js(true);
            this.oCY = ((tv)((LinkedList)localObject1).get(0)).oEo;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new diy();
            ((diy)localObject2).HQD = this.hDH;
            ae.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.hDH });
            localObject1 = new t((LinkedList)localObject1, (diy)localObject2, i, this.oCY);
            com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.fRv = 26;; this.fRv = 3)
        {
          this.oCY = getIntent().getStringExtra("key_card_id");
          this.oDm = am.bWh().oCP;
          if (this.oDm == null) {
            this.oDm = am.bWc().Zf(this.oCY);
          }
          bXp();
          if (this.oDm != null) {
            break label1695;
          }
          ae.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          A(true, -1);
          break;
        }
        label1695:
        bXs();
        bWN();
        bXq();
        if (this.oDm.bUW()) {
          am.bWp().YV(this.oDm.bVg());
        }
      }
      else
      {
        if (i == 26)
        {
          this.fRv = i;
          this.oCY = getIntent().getStringExtra("key_card_id");
          this.oLq = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.fRv = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.d.g.ZT((String)localObject1);
        if (localObject2 != null)
        {
          this.oCY = ((com.tencent.mm.plugin.card.model.d)localObject2).dJb;
          this.oLo = ((com.tencent.mm.plugin.card.model.d)localObject2).oBM;
          this.oLq = ((com.tencent.mm.plugin.card.model.d)localObject2).dJc;
        }
        this.oLp = com.tencent.mm.plugin.card.d.g.ZU((String)localObject1);
        break;
        label1846:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.oEy)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.oDm != null)) {
            break label2071;
          }
          ae.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.oCY + " isShareCard is " + this.oEy);
          js(true);
          this.GG.setVisibility(0);
          if (!this.oEy) {
            break label2064;
          }
          bXt();
          break;
          if (i == 15)
          {
            localObject1 = am.bWh().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.oDm = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.oEy)
          {
            this.oDm = am.bWk().Zv(this.oCY);
            i = 0;
          }
          else
          {
            this.oDm = am.bWc().Zf(this.oCY);
            i = 0;
          }
        }
        label2064:
        bXr();
      }
    }
    label2071:
    ae.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.oCY);
    Object localObject1 = this.oDm.bVf();
    if (localObject1 != null)
    {
      this.oDt = new ArrayList();
      this.oDt.add(localObject1);
    }
    bWN();
    if (this.oDm.bUW()) {
      am.bWp().YV(this.oDm.bVg());
    }
    if (this.oEy)
    {
      this.oLx = true;
      i = 1;
      label2178:
      if (i == 0) {
        break label2314;
      }
      ae.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.oCY + " isShareCard is " + this.oEy);
      if (!this.oEy) {
        break label2307;
      }
      bXt();
    }
    for (;;)
    {
      bXq();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.oDm.bVj() >= 86400L) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label2285;
        }
        this.oLx = true;
        i = 1;
        break;
      }
      label2285:
      if (!this.oDm.bUT()) {
        break label2178;
      }
      this.oLx = true;
      i = 1;
      break label2178;
      label2307:
      bXr();
      continue;
      label2314:
      bXs();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113214);
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    bXn();
    paramBundle = am.bWn();
    AppCompatActivity localAppCompatActivity = getContext();
    com.tencent.mm.kernel.g.ajQ().gDv.a(910, paramBundle);
    am.bWj().a(paramBundle);
    com.tencent.mm.plugin.card.b.b localb = am.bWb();
    if (localb.oCX == null) {
      localb.oCX = new ArrayList();
    }
    localb.oCX.add(new WeakReference(paramBundle));
    paramBundle.mContextRef = new WeakReference(localAppCompatActivity);
    am.bWn().a(this);
    am.bWo().a(this);
    paramBundle = am.bWp();
    com.tencent.mm.kernel.g.ajQ().gDv.a(577, paramBundle);
    paramBundle.oCZ.clear();
    paramBundle.oDa = 0;
    am.bWp().a(this);
    initView();
    AppMethodBeat.o(113214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113218);
    am.bWn().c(this);
    bXo();
    am.bWn().b(this);
    am.bWn().release();
    am.bWo().b(this);
    am.bWp().b(this);
    am.bWp().release();
    Object localObject1 = this.oLn;
    Object localObject2 = ((e)localObject1).oLZ;
    ((com.tencent.mm.plugin.card.b.f)localObject2).oDm = null;
    ((com.tencent.mm.plugin.card.b.f)localObject2).oDr.clear();
    ((e)localObject1).oLZ = null;
    localObject2 = ((e)localObject1).oLX;
    com.tencent.mm.plugin.card.d.l.U(((j)localObject2).oPT);
    int i = ((j)localObject2).oQa.size() - 1;
    while (i >= 0)
    {
      com.tencent.mm.plugin.card.d.l.U((Bitmap)((j)localObject2).oQa.remove(i));
      i -= 1;
    }
    ((j)localObject2).oQa.clear();
    if (((j)localObject2).jwx.isShowing()) {
      ((j)localObject2).jwx.dismiss();
    }
    ((j)localObject2).jwx = null;
    ((j)localObject2).bYt();
    ((j)localObject2).oPS = null;
    ((j)localObject2).oDm = null;
    ((e)localObject1).oLX = null;
    if (((e)localObject1).oLJ != null) {
      ((e)localObject1).oLJ.release();
    }
    ((e)localObject1).oDq.mmSetOnActivityResultCallback(null);
    com.tencent.mm.sdk.b.a.IvT.d(((e)localObject1).oMi);
    ((e)localObject1).oLF.destroy();
    ((e)localObject1).oLI.destroy();
    ((e)localObject1).oLH.destroy();
    ((e)localObject1).oLV.destroy();
    if (((e)localObject1).oLW != null) {
      ((e)localObject1).oLW.destroy();
    }
    if (((e)localObject1).oLO != null) {
      ((e)localObject1).oLO.destroy();
    }
    if (((e)localObject1).oLN != null) {
      ((e)localObject1).oLN.destroy();
    }
    if (((e)localObject1).oLP != null) {
      ((e)localObject1).oLP.destroy();
    }
    if (((e)localObject1).oLQ != null) {
      ((e)localObject1).oLQ.destroy();
    }
    if (((e)localObject1).oLR != null) {
      ((e)localObject1).oLR.destroy();
    }
    if (((e)localObject1).oLS != null) {
      ((e)localObject1).oLS.destroy();
    }
    if (((e)localObject1).oLT != null) {
      ((e)localObject1).oLT.destroy();
    }
    if (((e)localObject1).oLU != null) {
      ((e)localObject1).oLU.destroy();
    }
    if (((e)localObject1).oLL != null) {
      ((e)localObject1).oLL.destroy();
    }
    ((e)localObject1).oLE = null;
    localObject2 = am.bWs();
    if (((com.tencent.mm.plugin.card.b.g)localObject2).oCX != null)
    {
      i = 0;
      if (i < ((com.tencent.mm.plugin.card.b.g)localObject2).oCX.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.b.g)localObject2).oCX.get(i);
        if (localWeakReference == null) {
          break label748;
        }
        g.a locala = (g.a)localWeakReference.get();
        if ((locala == null) || (!locala.equals(localObject1))) {
          break label748;
        }
        ((com.tencent.mm.plugin.card.b.g)localObject2).oCX.remove(localWeakReference);
      }
    }
    am.bWs().release();
    this.nQa.cancel();
    bUB();
    long l = System.currentTimeMillis() - this.mStartTime;
    if (this.oDm != null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.fRv), this.oDm.bVh(), this.oDm.bVg(), Long.valueOf(l) });
      label611:
      if (((this.oLr) || (this.oLs)) && (this.oDm != null) && (this.oDm.bUI()))
      {
        if (!this.oDm.bUV()) {
          break label808;
        }
        am.bWo().cI(this.oCY, 2);
      }
      label667:
      localObject1 = this.oLB;
      ae.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.b.i)localObject1).oDE != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.b.i)localObject1).oDE;
        if (((i.a)localObject2).kGi != null) {
          break label822;
        }
        ae.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.b.i)localObject1).oDE = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).bVJ();
      ((com.tencent.mm.plugin.card.b.i)localObject1).oDJ = null;
      ((com.tencent.mm.plugin.card.b.i)localObject1).oDx = null;
      super.onDestroy();
      AppMethodBeat.o(113218);
      return;
      label748:
      i += 1;
      break;
      com.tencent.mm.plugin.report.service.g.yxI.f(13219, new Object[] { "CardDetailView", Integer.valueOf(this.fRv), this.oCY, this.oCY, Long.valueOf(l) });
      break label611;
      label808:
      am.bWo().cI(this.oCY, 1);
      break label667;
      label822:
      ak.getContext().unregisterReceiver(((i.a)localObject2).kGi);
      ((i.a)localObject2).kGi = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113232);
    if (paramInt == 4)
    {
      ae.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      A(false, -1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113232);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113216);
    bXo();
    super.onPause();
    this.oLn.dus = true;
    am.bWn().a(this, false);
    bi.a(this, null);
    com.tencent.mm.plugin.card.b.i locali = this.oLB;
    if (locali.bVM())
    {
      ae.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (locali.oDE != null) {
        locali.oDE.bVP();
      }
      locali.bVJ();
      com.tencent.mm.kernel.g.ajQ().gDv.b(2574, locali);
    }
    AppMethodBeat.o(113216);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113238);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113238);
      return;
    }
    ae.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113238);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ae.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.oKb);
        if (!this.oKb)
        {
          this.oKb = true;
          bWX();
        }
        AppMethodBeat.o(113238);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131757558), false, new CardDetailUI.4(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113215);
    super.onResume();
    bXn();
    if (this.hTg != null) {
      this.hTg.a(this.fHp, true);
    }
    this.oLn.dus = false;
    bi.a(this, this);
    am.bWn().a(this, true);
    Object localObject;
    int i;
    if (((this.oLr) || (this.oLs)) && (this.oDm.bUI()))
    {
      if (!this.oDm.bUV()) {
        break label224;
      }
      am.bWo().cI(this.oCY, 2);
      localObject = am.bWn();
      String str = this.oCY;
      localObject = (Boolean)((com.tencent.mm.plugin.card.b.d)localObject).oDl.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label208;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.bWn().oDo))) {
        break label213;
      }
      ae.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      YX(am.bWn().oDo);
      label171:
      this.oLn.oLL.d(com.tencent.mm.plugin.card.d.c.oVX);
    }
    for (;;)
    {
      if (this.oLB.cBE) {
        this.oLB.start();
      }
      AppMethodBeat.o(113215);
      return;
      label208:
      i = 0;
      break;
      label213:
      ae.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
      break label171;
      label224:
      am.bWo().cI(this.oCY, 1);
      localObject = this.oLn.oLL;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.d.c.oVX);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(113225);
    ae.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      js(false);
      this.GG.setVisibility(8);
      Object localObject;
      if ((paramn instanceof aa))
      {
        paramString = ((aa)paramn).oGs;
        if (TextUtils.isEmpty(paramString))
        {
          ae.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramn = this.oDm;
        localObject = new CardInfo();
        com.tencent.mm.plugin.card.d.f.a((CardInfo)localObject, paramString);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bVg()))
        {
          this.oCY = ((com.tencent.mm.plugin.card.base.b)localObject).bVg();
          this.oDm = ((com.tencent.mm.plugin.card.base.b)localObject);
          bXs();
          if (this.fRv == 3)
          {
            if (paramn != null)
            {
              ((CardInfo)this.oDm).field_stickyAnnouncement = ((CardInfo)paramn).field_stickyAnnouncement;
              ((CardInfo)this.oDm).field_stickyEndTime = ((CardInfo)paramn).field_stickyEndTime;
              ((CardInfo)this.oDm).field_stickyIndex = ((CardInfo)paramn).field_stickyIndex;
              ((CardInfo)this.oDm).field_label_wording = ((CardInfo)paramn).field_label_wording;
              this.oDm.a(paramn.bVf());
            }
            if (!this.oLx) {
              break label405;
            }
            com.tencent.mm.plugin.card.d.l.h(this.oDm);
          }
        }
        for (;;)
        {
          bWN();
          bXq();
          if (this.oDm.bUW()) {
            am.bWp().YV(this.oDm.bVg());
          }
          this.oLB.a(this, this.oCY, this.oDm, this.fHj, this.fHk);
          AppMethodBeat.o(113225);
          return;
          if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).bVg())) || (this.oCY.equals(((com.tencent.mm.plugin.card.base.b)localObject).bVh()))) {
            break;
          }
          ae.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.oCY, ((com.tencent.mm.plugin.card.base.b)localObject).bVh() });
          AppMethodBeat.o(113225);
          return;
          label405:
          ae.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.o))
      {
        if (this.oIS == 26) {
          js(false);
        }
        localObject = ((com.tencent.mm.plugin.card.model.o)paramn).oGs;
        paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramn).oGt;
        paramn = ((com.tencent.mm.plugin.card.model.o)paramn).oGu;
        if (paramInt1 != 0) {
          c(paramInt2, paramString, paramInt1, paramn);
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          ae.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
          AppMethodBeat.o(113225);
          return;
          com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131756802));
        }
        this.fRv = 3;
        if (this.oDm == null) {
          this.oDm = new CardInfo();
        }
        com.tencent.mm.plugin.card.d.f.a((CardInfo)this.oDm, (String)localObject);
        if (!TextUtils.isEmpty(this.oDm.bVg())) {
          this.oCY = this.oDm.bVg();
        }
        if (this.oLn.bXX() == 1)
        {
          paramString = this.oLn;
          if (paramString.oLZ != null)
          {
            paramString = paramString.oLZ;
            if (paramString.oDs != null) {
              paramString.oDs.oEB = false;
            }
          }
        }
        if (this.oIS != 26)
        {
          bXs();
          bWN();
        }
        com.tencent.mm.plugin.card.d.l.bZP();
        paramString = this.oDm;
        if (paramString.bUJ())
        {
          paramn = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMe, Integer.valueOf(0));
          if ((paramn == null) || (paramn.intValue() != 1))
          {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMe, Integer.valueOf(1));
            if (!com.tencent.mm.plugin.card.d.l.bZS()) {
              break label907;
            }
            com.tencent.mm.plugin.card.d.d.c(this, 2131493349, 2131756799, paramString.bVc().oFF);
          }
          label737:
          this.oLA = this.oDm.bVm();
          if ((this.oIS != 7) && (this.oIS != 16)) {
            break label929;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.oLA);
          setResult(-1, paramString);
          AM(-1);
        }
        for (;;)
        {
          if (this.oDm.bUW()) {
            am.bWp().YV(this.oDm.bVg());
          }
          this.oLB.a(this, this.oCY, this.oDm, this.fHj, this.fHk);
          AppMethodBeat.o(113225);
          return;
          paramn = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(282884, null);
          if ((paramn != null) && (paramn.intValue() == 1)) {
            break label737;
          }
          com.tencent.mm.kernel.g.ajR().ajA().set(282884, Integer.valueOf(1));
          break;
          label907:
          com.tencent.mm.plugin.card.d.d.c(this, 2131493348, 2131756798, paramString.bVc().oFF);
          break label737;
          label929:
          if ((!this.oLw) && (this.oIS == 8)) {
            A(true, -1);
          } else if ((this.oIS == 26) && (paramInt1 == 0)) {
            A(true, -1);
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.v))
      {
        this.oDt = ((com.tencent.mm.plugin.card.model.v)paramn).oGA;
        if ((this.oDm != null) && (this.oDt != null) && (this.oDt.size() > 0))
        {
          this.oDm.a((tn)this.oDt.get(0));
          bWN();
          if (this.oDm.bUI())
          {
            paramString = am.bWk().Zv(this.oCY);
            if (paramString != null)
            {
              paramString.a((tn)this.oDt.get(0));
              am.bWk().update(paramString, new String[] { this.oCY });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.bWc().Zf(this.oCY);
          if (paramString != null)
          {
            paramString.a((tn)this.oDt.get(0));
            am.bWc().update(paramString, new String[] { this.oCY });
          }
          AppMethodBeat.o(113225);
          return;
        }
        if ((this.oDm != null) && (this.oDt == null))
        {
          this.oDm.a(null);
          bWN();
          if (this.oDm.bUI())
          {
            paramString = am.bWk().Zv(this.oCY);
            if (paramString != null)
            {
              paramString.a(null);
              am.bWk().update(paramString, new String[] { this.oCY });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.bWc().Zf(this.oCY);
          if (paramString != null)
          {
            paramString.a(null);
            am.bWc().update(paramString, new String[] { this.oCY });
          }
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof af))
      {
        paramInt1 = ((af)paramn).oGt;
        localObject = ((af)paramn).oGu;
        if (paramInt1 == 10000)
        {
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = getString(2131756852);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          AppMethodBeat.o(113225);
          return;
        }
        this.oLq = ((af)paramn).dJc;
        ju(true);
        paramString = this.oDm.bVd();
        paramString.status = 3;
        this.oDm.a(paramString);
        com.tencent.mm.plugin.card.d.l.h(this.oDm);
        bWN();
        if (this.oIS == 3)
        {
          A(true, 2);
          AppMethodBeat.o(113225);
          return;
        }
        if (this.oIS == 15)
        {
          paramString = new to();
          com.tencent.mm.sdk.b.a.IvT.l(paramString);
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof r))
      {
        com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131756828));
        am.bWb();
        com.tencent.mm.plugin.card.b.b.AA(4);
        A(true, 1);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof t))
      {
        paramString = (t)paramn;
        paramn = paramString.oGy;
        if ((paramn != null) && (paramn.size() > 0))
        {
          paramn = (com.tencent.mm.plugin.card.base.b)paramn.get(0);
          if ((paramn != null) && (!this.oCY.equals(paramString.cardId)))
          {
            ae.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.oCY, paramString.cardId });
            AppMethodBeat.o(113225);
            return;
          }
          this.oDm = paramn;
          if (this.oDm != null)
          {
            this.oCY = this.oDm.bVg();
            bXs();
            if (this.oDm.bUW()) {
              am.bWp().YV(this.oDm.bVg());
            }
          }
          if (this.fRv == 26) {
            this.fRv = 3;
          }
          bWN();
        }
        bXq();
        com.tencent.mm.plugin.card.d.l.bZP();
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).oGs;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).oGt;
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.g)paramn).oGu;
        if (paramInt1 != 0)
        {
          paramString = paramn;
          if (TextUtils.isEmpty(paramn)) {
            paramString = getString(2131756790);
          }
          com.tencent.mm.plugin.card.d.d.c(this, paramString);
          ae.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
          AppMethodBeat.o(113225);
          return;
        }
        com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131756794));
        if (TextUtils.isEmpty(paramString))
        {
          ae.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
          AppMethodBeat.o(113225);
          return;
        }
        this.fRv = 3;
        if (this.oDm == null)
        {
          this.oDm = new ShareCardInfo();
          com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)this.oDm, paramString);
          paramn = (ShareCardInfo)this.oDm;
          if (!TextUtils.isEmpty(paramString)) {
            break label2147;
          }
          ae.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
          label1884:
          if (!TextUtils.isEmpty(this.oDm.bVg())) {
            this.oCY = this.oDm.bVg();
          }
          if (TextUtils.isEmpty(this.oDm.bVi())) {
            ((ShareCardInfo)this.oDm).field_from_username = com.tencent.mm.model.v.aAC();
          }
          com.tencent.mm.plugin.card.d.l.a((ShareCardInfo)this.oDm);
          bXs();
          bWN();
          com.tencent.mm.plugin.card.d.l.bZR();
          am.bWj().onChange();
          this.oLA = this.oDm.bVm();
          if ((this.oIS != 7) && (this.oIS != 16)) {
            break label2239;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.oLA);
          setResult(-1, paramString);
          AM(-1);
        }
        for (;;)
        {
          for (;;)
          {
            paramString = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMc, Integer.valueOf(0));
            if ((paramString == null) || (paramString.intValue() != 1))
            {
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMc, Integer.valueOf(1));
              com.tencent.mm.plugin.card.d.d.c(this, 2131493351, 2131756987, "");
            }
            if (this.oDm.bUW()) {
              am.bWp().YV(this.oDm.bVg());
            }
            AppMethodBeat.o(113225);
            return;
            if (!(this.oDm instanceof CardInfo)) {
              break;
            }
            this.oDm = new ShareCardInfo();
            break;
            try
            {
              label2147:
              paramString = new JSONObject(paramString).optJSONArray("card_list");
              if (paramString == null) {
                break label1884;
              }
              paramn.oEr = paramString.optJSONObject(0).optString("encrypt_code");
              ae.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramn.oEr);
            }
            catch (JSONException paramString)
            {
              ae.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
              ae.e("MicroMsg.CardInfoParser", paramString.getMessage());
            }
          }
          break label1884;
          label2239:
          if ((!this.oLw) && (this.oIS == 8)) {
            A(true, -1);
          }
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.c))
      {
        paramn = ((com.tencent.mm.plugin.card.sharecard.model.c)paramn).oGs;
        if (TextUtils.isEmpty(paramn))
        {
          ae.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramString = this.oDm;
        this.oDm = new ShareCardInfo();
        localObject = (ShareCardInfo)this.oDm;
        if (TextUtils.isEmpty(paramn))
        {
          ae.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
          if (paramString != null)
          {
            if (!TextUtils.isEmpty(paramString.bVi())) {
              ((ShareCardInfo)this.oDm).field_from_username = ((ShareCardInfo)paramString).field_from_username;
            }
            ((ShareCardInfo)this.oDm).field_app_id = ((ShareCardInfo)paramString).field_app_id;
            ((ShareCardInfo)this.oDm).field_consumer = ((ShareCardInfo)paramString).field_consumer;
            ((ShareCardInfo)this.oDm).field_share_time = ((ShareCardInfo)paramString).field_share_time;
            ((ShareCardInfo)this.oDm).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
            ((ShareCardInfo)this.oDm).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
            ((ShareCardInfo)this.oDm).field_end_time = ((ShareCardInfo)paramString).field_end_time;
            ((ShareCardInfo)this.oDm).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
            this.oDm.a(paramString.bVf());
            ((ShareCardInfo)this.oDm).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
            ((ShareCardInfo)this.oDm).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
            if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.oDm).field_status)
            {
              ae.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.oDm).field_status);
              com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.oDm);
            }
          }
          if (!TextUtils.isEmpty(this.oDm.bVg())) {
            this.oCY = this.oDm.bVg();
          }
          bWN();
          bXs();
          bXq();
          if (this.fRv == 3)
          {
            if (!this.oLx) {
              break label2740;
            }
            com.tencent.mm.plugin.card.d.l.h(this.oDm);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.oDm.bUW()) {
              am.bWp().YV(this.oDm.bVg());
            }
            AppMethodBeat.o(113225);
            return;
            try
            {
              com.tencent.mm.plugin.card.d.f.a((ShareCardInfo)localObject, new JSONObject(paramn));
            }
            catch (JSONException paramn)
            {
              ae.printErrStackTrace("MicroMsg.CardInfoParser", paramn, "", new Object[0]);
            }
          }
          break;
          label2740:
          ae.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
        }
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.sharecard.model.a))
      {
        if (((com.tencent.mm.plugin.card.sharecard.model.a)paramn).oGt != 0)
        {
          com.tencent.mm.plugin.card.d.d.c(this, getString(2131756826));
          AppMethodBeat.o(113225);
          return;
        }
        ae.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.oDm.bVg());
        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.oDm);
        com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131756828));
        am.bWj().bWD();
        A(true, -1);
        AppMethodBeat.o(113225);
      }
    }
    else
    {
      ae.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramn.getType());
      js(false);
      if (!(paramn instanceof af)) {
        break label3008;
      }
      ju(false);
      paramInt1 = ((af)paramn).oGt;
      paramn = ((af)paramn).oGu;
      if (paramInt1 != 10000) {
        break label3065;
      }
      paramString = paramn;
      if (TextUtils.isEmpty(paramn)) {
        paramString = getString(2131756852);
      }
    }
    label3008:
    label3065:
    for (;;)
    {
      paramn = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramn = getString(2131757027);
      }
      Toast.makeText(getContext(), paramn, 0).show();
      AppMethodBeat.o(113225);
      return;
      if ((paramn instanceof com.tencent.mm.plugin.card.model.o))
      {
        AM(0);
        c(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramn).oGt, ((com.tencent.mm.plugin.card.model.o)paramn).oGu);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.card.model.v))
      {
        AppMethodBeat.o(113225);
        return;
      }
    }
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113250);
    if ((this.oLn.oLL instanceof com.tencent.mm.plugin.card.ui.view.q))
    {
      ((com.tencent.mm.plugin.card.ui.view.q)this.oLn.oLL).oQb = am.bWp().getCode();
      this.oLn.bWN();
    }
    ae.i("MicroMsg.CardDetailUI", "code get success");
    AppMethodBeat.o(113250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI
 * JD-Core Version:    0.7.0.1
 */