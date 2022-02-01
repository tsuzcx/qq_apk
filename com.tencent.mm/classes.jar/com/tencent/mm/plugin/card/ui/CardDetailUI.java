package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.xf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.mgr.c.a;
import com.tencent.mm.plugin.card.mgr.f.a;
import com.tencent.mm.plugin.card.mgr.h.a;
import com.tencent.mm.plugin.card.mgr.i.a;
import com.tencent.mm.plugin.card.mgr.i.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.fhj;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardDetailUI
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.card.mgr.b.a, c.a, i.a, ScreenShotUtil.ScreenShotCallback
{
  private final String TAG;
  private View bEx;
  private int lCR;
  private w lKp;
  private float lsA;
  private com.tencent.mm.modelgeo.b.a lsF;
  private float lsz;
  MMHandler mHandler;
  private long mStartTime;
  private String nSg;
  private com.tencent.mm.modelgeo.d owr;
  private Vibrator uAL;
  private ArrayList<wl> wrB;
  private String wrg;
  private com.tencent.mm.plugin.card.base.b wru;
  private boolean wsH;
  private String wsu;
  private int wxa;
  private boolean wxn;
  private boolean wyi;
  private boolean wzA;
  private String wzB;
  private e.b wzC;
  private boolean wzD;
  private boolean wzE;
  private boolean wzF;
  private boolean wzG;
  private String wzH;
  private com.tencent.mm.plugin.card.mgr.h wzI;
  private int wzb;
  private String wzc;
  private String wzd;
  private String wze;
  e wzu;
  private String wzv;
  private String wzw;
  private String wzx;
  private boolean wzy;
  private boolean wzz;
  
  public CardDetailUI()
  {
    AppMethodBeat.i(113213);
    this.TAG = "MicroMsg.CardDetailUI";
    this.lKp = null;
    this.wrg = "";
    this.wsu = "";
    this.wzv = "";
    this.wzw = "";
    this.wzx = "";
    this.wzc = "";
    this.wzd = "";
    this.wze = "";
    this.wsH = false;
    this.wzy = false;
    this.wzz = false;
    this.wzA = false;
    this.nSg = "";
    this.wzB = "";
    this.wxn = false;
    this.mHandler = new MMHandler();
    this.lCR = 3;
    this.wzb = 0;
    this.wxa = -1;
    this.wzD = false;
    this.wzE = true;
    this.mStartTime = 0L;
    this.wzF = false;
    this.wyi = false;
    this.wzG = false;
    this.lsz = -85.0F;
    this.lsA = -1000.0F;
    this.wzH = "";
    this.wzI = new com.tencent.mm.plugin.card.mgr.h();
    this.lsF = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(293800);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(293800);
          return true;
        }
        if ((CardDetailUI.a(CardDetailUI.this) == -85.0F) && (CardDetailUI.b(CardDetailUI.this) == -1000.0F))
        {
          CardDetailUI.a(CardDetailUI.this, paramAnonymousFloat2);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousFloat1);
          am.dkP().aB(CardDetailUI.a(CardDetailUI.this), CardDetailUI.b(CardDetailUI.this));
        }
        CardDetailUI.c(CardDetailUI.this).aA(CardDetailUI.b(CardDetailUI.this), CardDetailUI.a(CardDetailUI.this));
        if (CardDetailUI.d(CardDetailUI.this))
        {
          CardDetailUI.e(CardDetailUI.this);
          CardDetailUI.f(CardDetailUI.this);
        }
        CardDetailUI.g(CardDetailUI.this);
        AppMethodBeat.o(293800);
        return false;
      }
    };
    AppMethodBeat.o(113213);
  }
  
  private void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(113233);
    Intent localIntent;
    if (paramInt == 1)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.wzH);
      localIntent.putExtra("key_card_id", this.wrg);
      localIntent.putExtra("key_finish_action", paramInt);
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.wxa == 7) || (this.wxa == 8) || (this.wxa == 16) || (this.wxa == 26)) && (this.lCR == 3))
    {
      localIntent = new Intent();
      localIntent.putExtra("key_code", this.wzH);
      if (paramInt > 0)
      {
        localIntent.putExtra("key_card_id", this.wrg);
        localIntent.putExtra("key_finish_action", paramInt);
      }
      setResult(-1, localIntent);
      if (paramBoolean) {
        finish();
      }
      AppMethodBeat.o(113233);
      return;
    }
    if (((this.wxa == 7) && (this.lCR == 7)) || ((this.wxa == 16) && (this.lCR == 16)) || ((this.wxa == 8) && (this.lCR == 8)) || ((this.wxa == 26) && (this.lCR == 26)))
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
  
  private void It(int paramInt)
  {
    AppMethodBeat.i(113234);
    if ((this.wxa != 7) && (this.wxa != 16))
    {
      Log.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
      AppMethodBeat.o(113234);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new com.tencent.mm.plugin.card.model.e();
    ((com.tencent.mm.plugin.card.model.e)localObject).wsy = this.wru.djP();
    ((com.tencent.mm.plugin.card.model.e)localObject).iaJ = this.wzx;
    ((com.tencent.mm.plugin.card.model.e)localObject).code = this.wzH;
    localLinkedList.add(localObject);
    localObject = new com.tencent.mm.autogen.a.c();
    ((com.tencent.mm.autogen.a.c)localObject).hyG.resultCode = paramInt;
    if (paramInt == -1) {}
    for (((com.tencent.mm.autogen.a.c)localObject).hyG.hyH = com.tencent.mm.plugin.card.c.h.a(localLinkedList, true, this.wxa);; ((com.tencent.mm.autogen.a.c)localObject).hyG.hyH = com.tencent.mm.plugin.card.c.h.a(localLinkedList, false, this.wxa))
    {
      ((com.tencent.mm.autogen.a.c)localObject).publish();
      AppMethodBeat.o(113234);
      return;
    }
  }
  
  private void a(i.b paramb)
  {
    AppMethodBeat.i(113247);
    if (this.wzu.hJi)
    {
      Log.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
      AppMethodBeat.o(113247);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
    this.wzu.a(this.wzA, paramb, true);
    AppMethodBeat.o(113247);
  }
  
  /* Error */
  private void akt(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 319
    //   5: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 131	com/tencent/mm/plugin/card/ui/CardDetailUI:wxn	Z
    //   12: ifeq +20 -> 32
    //   15: ldc 95
    //   17: ldc_w 321
    //   20: invokestatic 324	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 319
    //   26: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: ldc 95
    //   34: ldc_w 326
    //   37: invokestatic 213	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 131	com/tencent/mm/plugin/card/ui/CardDetailUI:wxn	Z
    //   45: new 181	android/content/Intent
    //   48: dup
    //   49: aload_0
    //   50: ldc_w 328
    //   53: invokespecial 331	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   56: astore_2
    //   57: aload_2
    //   58: ldc_w 333
    //   61: aload_0
    //   62: getfield 221	com/tencent/mm/plugin/card/ui/CardDetailUI:wru	Lcom/tencent/mm/plugin/card/base/b;
    //   65: invokeinterface 295 1 0
    //   70: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   73: pop
    //   74: aload_2
    //   75: ldc_w 335
    //   78: aload_1
    //   79: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_2
    //   84: ldc_w 337
    //   87: aload_0
    //   88: getfield 221	com/tencent/mm/plugin/card/ui/CardDetailUI:wru	Lcom/tencent/mm/plugin/card/base/b;
    //   91: invokeinterface 341 1 0
    //   96: getfield 346	com/tencent/mm/protocal/protobuf/ws:nRQ	Ljava/lang/String;
    //   99: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   102: pop
    //   103: aload_2
    //   104: ldc_w 348
    //   107: aload_0
    //   108: getfield 138	com/tencent/mm/plugin/card/ui/CardDetailUI:lCR	I
    //   111: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   114: pop
    //   115: aload_2
    //   116: ldc_w 350
    //   119: iconst_0
    //   120: invokevirtual 195	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   123: pop
    //   124: new 352	com/tencent/mm/hellhoundlib/b/a
    //   127: dup
    //   128: invokespecial 353	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   131: aload_2
    //   132: invokevirtual 357	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   135: astore_1
    //   136: aload_0
    //   137: aload_1
    //   138: invokevirtual 361	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   141: ldc_w 362
    //   144: ldc_w 364
    //   147: ldc_w 365
    //   150: ldc_w 367
    //   153: ldc_w 369
    //   156: ldc_w 371
    //   159: invokestatic 377	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: aload_1
    //   164: iconst_0
    //   165: invokevirtual 381	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   168: checkcast 181	android/content/Intent
    //   171: invokevirtual 383	com/tencent/mm/plugin/card/ui/CardDetailUI:startActivity	(Landroid/content/Intent;)V
    //   174: aload_0
    //   175: ldc_w 362
    //   178: ldc_w 364
    //   181: ldc_w 365
    //   184: ldc_w 367
    //   187: ldc_w 369
    //   190: ldc_w 371
    //   193: invokestatic 387	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   196: ldc_w 319
    //   199: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void c(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(113226);
    Log.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + paramInt1 + " errMsg = " + paramString1 + " ret_code:" + paramInt2 + " ret_msg:" + paramString2);
    if (paramInt2 == 10000)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = getString(a.g.wnW);
      }
      this.wru.djL().status = 4;
      dlx();
    }
    for (;;)
    {
      com.tencent.mm.plugin.card.c.d.b(this, paramString1);
      AppMethodBeat.o(113226);
      return;
      if (paramInt2 == 10001)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(a.g.wnZ);
        }
        this.wru.djL().status = 5;
        dlx();
      }
      else if (paramInt2 == 10002)
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(a.g.wpG);
        }
      }
      else
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = getString(a.g.wnU);
        }
      }
    }
  }
  
  private void djf()
  {
    AppMethodBeat.i(113235);
    if (this.owr == null) {
      this.owr = com.tencent.mm.modelgeo.d.bJl();
    }
    dmd();
    AppMethodBeat.o(113235);
  }
  
  private void dji()
  {
    AppMethodBeat.i(113236);
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
    AppMethodBeat.o(113236);
  }
  
  private void dlW()
  {
    AppMethodBeat.i(113219);
    com.tencent.mm.kernel.h.baD().mCm.a(1057, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1037, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1058, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1045, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1077, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1099, this);
    com.tencent.mm.kernel.h.baD().mCm.a(902, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1051, this);
    com.tencent.mm.kernel.h.baD().mCm.a(1163, this);
    AppMethodBeat.o(113219);
  }
  
  private void dlX()
  {
    AppMethodBeat.i(113220);
    com.tencent.mm.kernel.h.baD().mCm.b(1057, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1037, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1058, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1045, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1077, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1099, this);
    com.tencent.mm.kernel.h.baD().mCm.b(902, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1051, this);
    com.tencent.mm.kernel.h.baD().mCm.b(1163, this);
    AppMethodBeat.o(113220);
  }
  
  private void dlY()
  {
    AppMethodBeat.i(113222);
    this.wxa = this.lCR;
    this.wzC = new e.b();
    this.wzC.lCR = this.lCR;
    this.wzC.wxa = this.wxa;
    this.wzC.wrg = this.wrg;
    this.wzC.wzv = this.wzv;
    this.wzC.wzx = this.wzx;
    this.wzC.wzw = this.wzw;
    this.wzC.wzc = this.wzc;
    this.wzC.wzd = this.wzd;
    this.wzC.wsH = this.wsH;
    this.wzC.wAu = getIntent().getIntExtra("key_from_appbrand_type", 0);
    AppMethodBeat.o(113222);
  }
  
  private void dlZ()
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113223);
    if ((this.wzF) || (this.wru == null))
    {
      AppMethodBeat.o(113223);
      return;
    }
    this.wzF = true;
    if (this.wsH)
    {
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      j = this.wru.djK().tNW;
      str1 = this.wru.djP();
      str2 = this.wru.djO();
      k = this.wxa;
      str3 = this.wzv;
      if (this.wru.djI()) {}
      for (;;)
      {
        localh.b(11324, new Object[] { "ShareCardDetailUI", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
        AppMethodBeat.o(113223);
        return;
        i = 0;
      }
    }
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    int k = this.wru.djK().tNW;
    String str1 = this.wru.djP();
    String str2 = this.wru.djO();
    int m = this.wxa;
    String str3 = this.wzv;
    if (this.wru.djI()) {}
    for (i = j;; i = 0)
    {
      localh.b(11324, new Object[] { "CardDetailView", Integer.valueOf(k), str1, str2, Integer.valueOf(0), Integer.valueOf(m), str3, Integer.valueOf(i), "" });
      AppMethodBeat.o(113223);
      return;
    }
  }
  
  private void dlx()
  {
    AppMethodBeat.i(113224);
    this.wzC.lCR = this.lCR;
    this.wzC.wxa = this.wxa;
    this.wzC.wrg = this.wrg;
    this.wzu.a(this.wru, this.wzC, this.wrB);
    this.wzu.dlx();
    am.dkU().wru = this.wru;
    AppMethodBeat.o(113224);
  }
  
  private void dma()
  {
    AppMethodBeat.i(113229);
    Object localObject = new fhj();
    ((fhj)localObject).abHW = this.nSg;
    ((fhj)localObject).wtP = this.wzB;
    Log.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[] { this.nSg });
    localObject = new aa(this.wrg, this.lCR, this.wzv, this.wzx, this.wzc, this.wzd, this.wzb, this.wze, (fhj)localObject);
    com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
    AppMethodBeat.o(113229);
  }
  
  private void dmb()
  {
    AppMethodBeat.i(113230);
    Object localObject;
    if (!TextUtils.isEmpty(this.wru.djP())) {
      localObject = this.wru.djP();
    }
    while ((this.wru != null) && (this.wru.djK().ZdO == 1))
    {
      float f2 = this.lsz;
      float f3 = this.lsA;
      float f1;
      if (f2 != -85.0F)
      {
        f1 = f3;
        if (f3 != -1000.0F) {}
      }
      else
      {
        f2 = am.dkP().lsz;
        f1 = am.dkP().lsA;
      }
      localObject = new com.tencent.mm.plugin.card.model.v((String)localObject, f1, f2, this.wru.djO());
      com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
      AppMethodBeat.o(113230);
      return;
      if (!TextUtils.isEmpty(this.wrg))
      {
        localObject = this.wrg;
      }
      else
      {
        Log.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
        AppMethodBeat.o(113230);
        return;
      }
    }
    if ((this.wru != null) && (this.wru.djK().ZdO > 1))
    {
      if ((this.lsz != -85.0F) && (this.lsA != -1000.0F))
      {
        this.wzG = false;
        localObject = new com.tencent.mm.plugin.card.model.v((String)localObject, this.lsA, this.lsz, this.wru.djO());
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
        AppMethodBeat.o(113230);
        return;
      }
      if (!this.wzG)
      {
        this.wzG = true;
        if (this.wyi)
        {
          djf();
          AppMethodBeat.o(113230);
        }
      }
    }
    else if (this.wru != null)
    {
      this.wru.a(null);
      dlx();
      if (this.wru.djp())
      {
        localObject = am.dkR().akS(this.wrg);
        if (localObject != null)
        {
          ((ShareCardInfo)localObject).a(null);
          am.dkR().update((IAutoDBItem)localObject, new String[] { this.wrg });
        }
        AppMethodBeat.o(113230);
        return;
      }
      localObject = am.dkJ().akC(this.wrg);
      if (localObject != null)
      {
        ((CardInfo)localObject).a(null);
        am.dkJ().update((IAutoDBItem)localObject, new String[] { this.wrg });
      }
    }
    AppMethodBeat.o(113230);
  }
  
  private void dmc()
  {
    AppMethodBeat.i(113231);
    com.tencent.mm.plugin.card.sharecard.model.c localc = new com.tencent.mm.plugin.card.sharecard.model.c(this.wrg);
    com.tencent.mm.kernel.h.baD().mCm.a(localc, 0);
    AppMethodBeat.o(113231);
  }
  
  private void dmd()
  {
    AppMethodBeat.i(293799);
    dhb localdhb = aj.dch();
    if ((this.lsz == -85.0F) && (this.lsA == -1000.0F))
    {
      if (localdhb == null) {
        break label138;
      }
      this.lsz = localdhb.ZaH;
    }
    for (this.lsA = localdhb.ZaG;; this.lsA = 0.0F)
    {
      am.dkP().aB(this.lsz, this.lsA);
      Log.i("MicroMsg.CardDetailUI", "refreshLbs lbsLatitude:%s，lbsLongitude：%s", new Object[] { Float.valueOf(this.lsz), Float.valueOf(this.lsA) });
      this.wzI.aA(this.lsA, this.lsz);
      if (this.wzG)
      {
        dmb();
        this.wzG = false;
      }
      dji();
      AppMethodBeat.o(293799);
      return;
      label138:
      this.lsz = 0.0F;
    }
  }
  
  private void na(boolean paramBoolean)
  {
    AppMethodBeat.i(113227);
    if (paramBoolean)
    {
      this.lKp = w.a(this, getString(a.g.loading_tips), true, 0, null);
      AppMethodBeat.o(113227);
      return;
    }
    if ((this.lKp != null) && (this.lKp.isShowing()))
    {
      this.lKp.dismiss();
      this.lKp = null;
    }
    AppMethodBeat.o(113227);
  }
  
  private void nc(boolean paramBoolean)
  {
    AppMethodBeat.i(113228);
    if (paramBoolean) {
      l.go(this.wzu.wAj, this.wzu.wAi);
    }
    AppMethodBeat.o(113228);
  }
  
  public final void akr(String paramString)
  {
    AppMethodBeat.i(113249);
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.mm.plugin.card.c.d.a(this, paramString, true);
    }
    AppMethodBeat.o(113249);
  }
  
  public final void aku(final String paramString)
  {
    AppMethodBeat.i(113243);
    if (!this.wzu.dmH())
    {
      Log.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
      AppMethodBeat.o(113243);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
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
  
  public final void akx(String paramString)
  {
    AppMethodBeat.i(113246);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.wrg)))
    {
      Log.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113246);
      return;
    }
    this.wzy = false;
    AppMethodBeat.o(113246);
  }
  
  public final void b(String paramString, i.b paramb)
  {
    AppMethodBeat.i(113244);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.wrg)))
    {
      Log.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
      AppMethodBeat.o(113244);
      return;
    }
    na(false);
    Log.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
    Log.i("MicroMsg.CardDetailUI", "markSucc:" + paramb.wsm + " markCardId: " + paramb.wsn);
    this.wzz = false;
    if (paramb.wsm == 1)
    {
      if ((!TextUtils.isEmpty(paramb.wsn)) && (!this.wru.djO().equals(paramb.wsn)))
      {
        Log.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
        if (this.wru.djp())
        {
          paramString = am.dkR().akS(paramb.wsn);
          if (paramString != null)
          {
            this.wru = paramString;
            this.wrg = paramb.wsn;
            dlx();
            am.dkU().b(this.wru);
            Log.i("MicroMsg.CardDetailUI", "update the mCardInfo");
            this.wzy = true;
            a(paramb);
            AppMethodBeat.o(113244);
            return;
          }
          Log.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
          com.tencent.mm.plugin.card.c.d.b(this, getString(a.g.wps));
          this.wzy = false;
          AppMethodBeat.o(113244);
        }
      }
      else
      {
        Log.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
        this.wzy = true;
        a(paramb);
        AppMethodBeat.o(113244);
      }
    }
    else
    {
      this.wzy = false;
      com.tencent.mm.plugin.card.c.d.b(this, getString(a.g.wpt));
    }
    AppMethodBeat.o(113244);
  }
  
  public final void d(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113240);
    if (paramb == null)
    {
      Log.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if ((this.wru == null) || (!this.wru.djO().equals(paramb.djO())))
    {
      Log.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    if (!this.wzu.dmH())
    {
      Log.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
      AppMethodBeat.o(113240);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onDataChange");
    this.wru = paramb;
    this.wrg = this.wru.djO();
    if ((this.wru.djD()) && (am.dkW().isEmpty())) {
      am.dkW().aks(this.wru.djO());
    }
    dlx();
    AppMethodBeat.o(113240);
  }
  
  public final void dkd()
  {
    AppMethodBeat.i(113248);
    Log.i("MicroMsg.CardDetailUI", "code change");
    if ((this.wzu.wzT instanceof q))
    {
      ((q)this.wzu.wzT).wEh = am.dkW().getCode();
      this.wzu.dlx();
    }
    AppMethodBeat.o(113248);
  }
  
  public final void dki()
  {
    AppMethodBeat.i(113241);
    Log.i("MicroMsg.CardDetailUI", "onVibrate");
    this.uAL.vibrate(300L);
    AppMethodBeat.o(113241);
  }
  
  public final void dkj()
  {
    AppMethodBeat.i(113242);
    Log.i("MicroMsg.CardDetailUI", "onFinishUI");
    AppMethodBeat.o(113242);
  }
  
  public final void gd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113245);
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(this.wrg)))
    {
      Log.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
      AppMethodBeat.o(113245);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onMarkFail()");
    this.wzy = false;
    this.wzz = false;
    na(false);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = getString(a.g.wps);
    }
    com.tencent.mm.plugin.card.c.d.b(this, paramString1);
    AppMethodBeat.o(113245);
  }
  
  public int getLayoutId()
  {
    return a.e.wmy;
  }
  
  public void initView()
  {
    int j = 0;
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
    this.uAL = ((Vibrator)getSystemService("vibrator"));
    this.bEx = findViewById(a.d.wga);
    Object localObject2;
    if (this.wzu == null)
    {
      this.wzu = new e(this, getContentView());
      localObject1 = this.wzu;
      ((e)localObject1).wAf = new j(((e)localObject1).wry);
      localObject2 = ((e)localObject1).wAf;
      ((j)localObject2).wwW = ((j)localObject2).pVV.getWindow().getAttributes().screenBrightness;
      if (((j)localObject2).qjH == null)
      {
        View localView = View.inflate(((j)localObject2).pVV, a.e.wnw, null);
        ((j)localObject2).qjJ = localView.findViewById(a.d.popupwd_qrcode_layout);
        ((j)localObject2).qjI = ((ImageView)localView.findViewById(a.d.popupwd_qrcode_iv));
        ((j)localObject2).wEa = ((TextView)localView.findViewById(a.d.wkQ));
        ((j)localObject2).wEb = ((TextView)localView.findViewById(a.d.wkP));
        ((j)localObject2).wEc = localView.findViewById(a.d.popupwd_barcode_layout);
        ((j)localObject2).wEd = ((ImageView)localView.findViewById(a.d.popupwd_barcode_iv));
        ((j)localObject2).wEe = ((MMVerticalTextView)localView.findViewById(a.d.vertical_barcode_text));
        ((j)localObject2).wEf = ((MMVerticalTextView)localView.findViewById(a.d.wmf));
        localView.setOnClickListener(new j.2((j)localObject2));
        ((j)localObject2).qjH = new com.tencent.mm.ui.base.v(localView, -1, -1, true);
        ((j)localObject2).qjH.update();
        ((j)localObject2).qjH.setBackgroundDrawable(new ColorDrawable(16777215));
        ((j)localObject2).qjH.setOnDismissListener(new j.3((j)localObject2));
      }
      ((e)localObject1).wry.setMMTitle("");
      ((e)localObject1).wry.setActionbarColor(((e)localObject1).wry.getResources().getColor(a.a.white));
      ((e)localObject1).wAh = new com.tencent.mm.plugin.card.mgr.e(((e)localObject1).wry);
      ((e)localObject1).wry.mmSetOnActivityResultCallback((MMActivity.a)localObject1);
      ((e)localObject1).wAq.alive();
      localObject1 = this.wzu;
      if (((e)localObject1).wzN == null)
      {
        ((e)localObject1).wzN = new x();
        ((e)localObject1).wzN.a((n)localObject1);
      }
      if (((e)localObject1).wzP == null)
      {
        ((e)localObject1).wzP = new com.tencent.mm.plugin.card.ui.view.o();
        ((e)localObject1).wzP.a((n)localObject1);
      }
      if (((e)localObject1).wzQ == null)
      {
        ((e)localObject1).wzQ = new com.tencent.mm.plugin.card.ui.view.a();
        ((e)localObject1).wzQ.a((n)localObject1);
      }
      ((e)localObject1).mListView = ((ListView)((e)localObject1).findViewById(a.d.whZ));
      ((e)localObject1).wzU = new m(((e)localObject1).wry.getContext());
      ((e)localObject1).wzU.wEM = ((e)localObject1).qjL;
      ((e)localObject1).mListView.setAdapter(((e)localObject1).wzU);
      ((e)localObject1).wzU.notifyDataSetChanged();
      ((e)localObject1).mListView.setOnItemClickListener(new e.1((e)localObject1));
      Log.i("MicroMsg.CardDetailUIContoller", "initMenu");
      ((e)localObject1).wry.addIconOptionMenu(0, a.f.icons_outlined_more, new e.7((e)localObject1));
      ((e)localObject1).wzS = ((LinearLayout)((e)localObject1).findViewById(a.d.header_view));
      ((e)localObject1).wAd = new com.tencent.mm.plugin.card.ui.view.d();
      ((e)localObject1).wAd.a((n)localObject1);
      ((e)localObject1).wAf.wru = ((e)localObject1).wru;
    }
    int i = getIntent().getIntExtra("key_from_scene", -1);
    Log.i("MicroMsg.CardDetailUI", "scene:%d", new Object[] { Integer.valueOf(i) });
    if ((i == 2) || (i == 6) || (i == 5))
    {
      this.lCR = i;
      localObject1 = getIntent().getStringExtra("key_card_app_msg");
      localObject2 = com.tencent.mm.plugin.card.c.g.alq((String)localObject1);
      if (localObject2 != null)
      {
        this.wrg = ((com.tencent.mm.plugin.card.model.d)localObject2).iaI;
        this.wzv = ((com.tencent.mm.plugin.card.model.d)localObject2).from_username;
        this.wzx = ((com.tencent.mm.plugin.card.model.d)localObject2).iaJ;
        int k = ((com.tencent.mm.plugin.card.model.d)localObject2).wtO;
        Log.i("MicroMsg.CardDetailUI", "scene is " + i + ", isRecommend is " + k);
        if ((k == 1) && (i == 2)) {
          this.lCR = 23;
        }
        this.wzB = ((com.tencent.mm.plugin.card.model.d)localObject2).wtP;
        Log.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.wzB);
      }
      this.wzw = com.tencent.mm.plugin.card.c.g.alr((String)localObject1);
      dlY();
      if (!TextUtils.isEmpty(this.wrg)) {
        break label1843;
      }
      Log.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
      D(true, -1);
    }
    for (;;)
    {
      this.wzu.a(this.wru, this.wzC, this.wrB);
      this.wzu.wAn = new e.e()
      {
        public final void akX(String paramAnonymousString)
        {
          AppMethodBeat.i(113202);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousString);
          AppMethodBeat.o(113202);
        }
        
        public final void b(com.tencent.mm.plugin.card.base.b paramAnonymousb)
        {
          AppMethodBeat.i(113207);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousb);
          CardDetailUI.b(CardDetailUI.this, paramAnonymousb.djO());
          CardDetailUI.m(CardDetailUI.this).wrg = CardDetailUI.n(CardDetailUI.this);
          AppMethodBeat.o(113207);
        }
        
        public final void dmc()
        {
          AppMethodBeat.i(113208);
          CardDetailUI.o(CardDetailUI.this);
          AppMethodBeat.o(113208);
        }
        
        public final void dme()
        {
          AppMethodBeat.i(113201);
          CardDetailUI.i(CardDetailUI.this);
          AppMethodBeat.o(113201);
        }
        
        public final void dmf()
        {
          AppMethodBeat.i(113203);
          CardDetailUI.j(CardDetailUI.this);
          AppMethodBeat.o(113203);
        }
        
        public final void dmg()
        {
          AppMethodBeat.i(113204);
          CardDetailUI.k(CardDetailUI.this);
          AppMethodBeat.o(113204);
        }
        
        public final void dmh()
        {
          AppMethodBeat.i(113205);
          CardDetailUI.h(CardDetailUI.this);
          AppMethodBeat.o(113205);
        }
        
        public final void dmi()
        {
          AppMethodBeat.i(113206);
          CardDetailUI.l(CardDetailUI.this);
          AppMethodBeat.o(113206);
        }
        
        public final void dmj()
        {
          AppMethodBeat.i(113209);
          Log.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
          AppMethodBeat.o(113209);
        }
        
        public final void nd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(113210);
          Log.i("MicroMsg.CardDetailUI", "doMark()");
          CardDetailUI.p(CardDetailUI.this);
          CardDetailUI.q(CardDetailUI.this);
          CardDetailUI.a(CardDetailUI.this, paramAnonymousBoolean);
          if (CardDetailUI.r(CardDetailUI.this).djC())
          {
            am.dkV().ab(CardDetailUI.n(CardDetailUI.this), l.alB(CardDetailUI.r(CardDetailUI.this).djQ()), 2);
            AppMethodBeat.o(113210);
            return;
          }
          am.dkV().ab(CardDetailUI.n(CardDetailUI.this), l.alB(CardDetailUI.r(CardDetailUI.this).djQ()), 1);
          AppMethodBeat.o(113210);
        }
      };
      this.wyi = true;
      if (this.wyi)
      {
        this.owr = com.tencent.mm.modelgeo.d.bJl();
        djf();
      }
      AppMethodBeat.o(113221);
      return;
      if ((l.IM(i)) || (i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 9) || (i == 12) || (i == 15) || (i == 17) || (i == 21))
      {
        this.lCR = i;
        this.wrg = getIntent().getStringExtra("key_card_id");
        this.wzx = getIntent().getStringExtra("key_card_ext");
        this.wsH = getIntent().getBooleanExtra("key_is_share_card", false);
        this.wzb = getIntent().getIntExtra("key_stastic_scene", 0);
        this.wze = getIntent().getStringExtra("key_consumed_card_id");
        if ((i == 7) || (i == 16))
        {
          this.wzc = getIntent().getStringExtra("src_username");
          this.wzd = getIntent().getStringExtra("js_url");
          this.nSg = getIntent().getStringExtra("key_template_id");
          break;
        }
        if ((this.wsH) && (i == 3))
        {
          this.wsu = getIntent().getStringExtra("key_card_tp_id");
          this.wrg = com.tencent.mm.plugin.card.sharecard.a.b.gh(this.wrg, this.wsu);
          break;
        }
        if (i != 8) {
          break;
        }
        this.wzD = getIntent().getBooleanExtra("key_is_sms_add_card", false);
        break;
      }
      if ((i == 50) || (i == 27))
      {
        this.lCR = getIntent().getIntExtra("key_previous_scene", 50);
        if ((this.lCR != 26) && (this.lCR != 27)) {
          this.lCR = 3;
        }
        this.nSg = getIntent().getStringExtra("key_template_id");
        if (this.lCR == 27)
        {
          localObject1 = (com.tencent.mm.plugin.card.base.b)getIntent().getParcelableExtra("key_card_info");
          if (localObject1 != null)
          {
            this.wru = ((com.tencent.mm.plugin.card.base.b)localObject1);
            this.wrg = this.wru.djO();
            dlY();
            dmb();
            if (this.wru.djD()) {
              am.dkW().aks(this.wru.djO());
            }
            dlx();
          }
          dlZ();
          l.doO();
        }
        else
        {
          localObject1 = getIntent().getStringExtra("card_list");
          localObject2 = getIntent().getStringExtra("key_app_id");
          localObject1 = com.tencent.mm.plugin.card.c.k.J((String)localObject1, this.lCR, (String)localObject2);
          if ((localObject1 == null) || (((LinkedList)localObject1).size() == 0))
          {
            Log.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
            D(true, -1);
          }
          for (;;)
          {
            dlY();
            break;
            na(true);
            this.wrg = ((wt)((LinkedList)localObject1).get(0)).wsy;
            i = getIntent().getIntExtra("key_previous_scene", 51);
            localObject2 = new fhj();
            ((fhj)localObject2).abHW = this.nSg;
            Log.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[] { this.nSg });
            localObject1 = new t((LinkedList)localObject1, (fhj)localObject2, i, this.wrg);
            com.tencent.mm.kernel.h.baD().mCm.a((p)localObject1, 0);
          }
        }
      }
      else if (i == 51)
      {
        if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {}
        for (this.lCR = 26;; this.lCR = 3)
        {
          this.wrg = getIntent().getStringExtra("key_card_id");
          this.wru = am.dkO().wqY;
          if (this.wru == null) {
            this.wru = am.dkJ().akC(this.wrg);
          }
          dlY();
          if (this.wru != null) {
            break label1662;
          }
          Log.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
          D(true, -1);
          break;
        }
        label1662:
        dmb();
        dlx();
        dlZ();
        if (this.wru.djD()) {
          am.dkW().aks(this.wru.djO());
        }
      }
      else
      {
        if (i == 26)
        {
          this.lCR = i;
          this.wrg = getIntent().getStringExtra("key_card_id");
          this.wzx = getIntent().getStringExtra("key_card_ext");
          break;
        }
        this.lCR = i;
        localObject1 = getIntent().getStringExtra("key_card_app_msg");
        localObject2 = com.tencent.mm.plugin.card.c.g.alq((String)localObject1);
        if (localObject2 != null)
        {
          this.wrg = ((com.tencent.mm.plugin.card.model.d)localObject2).iaI;
          this.wzv = ((com.tencent.mm.plugin.card.model.d)localObject2).from_username;
        }
        for (this.wzx = ((com.tencent.mm.plugin.card.model.d)localObject2).iaJ;; this.wzx = getIntent().getStringExtra("key_card_ext"))
        {
          this.wzw = com.tencent.mm.plugin.card.c.g.alr((String)localObject1);
          break;
          this.wrg = getIntent().getStringExtra("key_card_id");
        }
        label1843:
        if ((i == 2) || (i == 6) || ((i == 4) && (!this.wsH)) || (i == 5) || (i == 17) || (i == 21) || (i == 23)) {
          i = 1;
        }
        for (;;)
        {
          if ((i == 0) && (this.wru != null)) {
            break label2068;
          }
          Log.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.wrg + " isShareCard is " + this.wsH);
          na(true);
          this.bEx.setVisibility(0);
          if (!this.wsH) {
            break label2061;
          }
          dmc();
          break;
          if (i == 15)
          {
            localObject1 = am.dkO().getValue("key_accept_card_info");
            if ((localObject1 != null) && ((localObject1 instanceof CardInfo)))
            {
              this.wru = ((CardInfo)localObject1);
              i = 0;
            }
            else
            {
              i = 1;
            }
          }
          else if (this.wsH)
          {
            this.wru = am.dkR().akS(this.wrg);
            i = 0;
          }
          else
          {
            this.wru = am.dkJ().akC(this.wrg);
            i = 0;
          }
        }
        label2061:
        dma();
      }
    }
    label2068:
    Log.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.wrg);
    Object localObject1 = this.wru.djN();
    if (localObject1 != null)
    {
      this.wrB = new ArrayList();
      this.wrB.add(localObject1);
    }
    dlx();
    if (this.wru.djD()) {
      am.dkW().aks(this.wru.djO());
    }
    if (this.wsH)
    {
      this.wzE = true;
      i = 1;
      label2175:
      if (i == 0) {
        break label2306;
      }
      Log.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.wrg + " isShareCard is " + this.wsH);
      if (!this.wsH) {
        break label2299;
      }
      dmc();
    }
    for (;;)
    {
      dlZ();
      break;
      if ((int)(System.currentTimeMillis() / 1000L) - this.wru.djR() >= 86400L) {
        j = 1;
      }
      if (j != 0)
      {
        this.wzE = true;
        i = 1;
        break label2175;
      }
      if (!this.wru.djA()) {
        break label2175;
      }
      this.wzE = true;
      i = 1;
      break label2175;
      label2299:
      dma();
      continue;
      label2306:
      dmb();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113214);
    super.onCreate(paramBundle);
    this.mStartTime = System.currentTimeMillis();
    dlW();
    paramBundle = am.dkU();
    AppCompatActivity localAppCompatActivity = getContext();
    com.tencent.mm.kernel.h.baD().mCm.a(910, paramBundle);
    am.dkQ().a(paramBundle);
    com.tencent.mm.plugin.card.mgr.a locala = am.dkI();
    if (locala.eNV == null) {
      locala.eNV = new ArrayList();
    }
    locala.eNV.add(new WeakReference(paramBundle));
    paramBundle.mContextRef = new WeakReference(localAppCompatActivity);
    am.dkU().a(this);
    am.dkV().a(this);
    paramBundle = am.dkW();
    com.tencent.mm.kernel.h.baD().mCm.a(577, paramBundle);
    paramBundle.wrh.clear();
    paramBundle.wri = 0;
    am.dkW().a(this);
    initView();
    AppMethodBeat.o(113214);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(113218);
    am.dkU().c(this);
    dlX();
    am.dkU().b(this);
    am.dkU().release();
    am.dkV().b(this);
    am.dkW().b(this);
    am.dkW().release();
    Object localObject1 = this.wzu;
    Object localObject2 = ((e)localObject1).wAh;
    ((com.tencent.mm.plugin.card.mgr.e)localObject2).wru = null;
    ((com.tencent.mm.plugin.card.mgr.e)localObject2).wrz.clear();
    ((e)localObject1).wAh = null;
    localObject2 = ((e)localObject1).wAf;
    l.ah(((j)localObject2).wDZ);
    int i = ((j)localObject2).wEg.size() - 1;
    while (i >= 0)
    {
      l.ah((Bitmap)((j)localObject2).wEg.remove(i));
      i -= 1;
    }
    ((j)localObject2).wEg.clear();
    if (((j)localObject2).qjH.isShowing()) {
      ((j)localObject2).qjH.dismiss();
    }
    ((j)localObject2).qjH = null;
    ((j)localObject2).dnb();
    ((j)localObject2).pVV = null;
    ((j)localObject2).wru = null;
    ((e)localObject1).wAf = null;
    if (((e)localObject1).wzR != null) {
      ((e)localObject1).wzR.release();
    }
    ((e)localObject1).wry.mmSetOnActivityResultCallback(null);
    ((e)localObject1).wAq.dead();
    ((e)localObject1).wzN.destroy();
    ((e)localObject1).wzQ.destroy();
    ((e)localObject1).wzP.destroy();
    ((e)localObject1).wAd.destroy();
    if (((e)localObject1).wAe != null) {
      ((e)localObject1).wAe.destroy();
    }
    if (((e)localObject1).wzW != null) {
      ((e)localObject1).wzW.destroy();
    }
    if (((e)localObject1).wzV != null) {
      ((e)localObject1).wzV.destroy();
    }
    if (((e)localObject1).wzX != null) {
      ((e)localObject1).wzX.destroy();
    }
    if (((e)localObject1).wzY != null) {
      ((e)localObject1).wzY.destroy();
    }
    if (((e)localObject1).wzZ != null) {
      ((e)localObject1).wzZ.destroy();
    }
    if (((e)localObject1).wAa != null) {
      ((e)localObject1).wAa.destroy();
    }
    if (((e)localObject1).wAb != null) {
      ((e)localObject1).wAb.destroy();
    }
    if (((e)localObject1).wAc != null) {
      ((e)localObject1).wAc.destroy();
    }
    if (((e)localObject1).wzT != null) {
      ((e)localObject1).wzT.destroy();
    }
    ((e)localObject1).wzM = null;
    localObject2 = am.dkZ();
    if (((com.tencent.mm.plugin.card.mgr.f)localObject2).eNV != null)
    {
      i = 0;
      if (i < ((com.tencent.mm.plugin.card.mgr.f)localObject2).eNV.size())
      {
        WeakReference localWeakReference = (WeakReference)((com.tencent.mm.plugin.card.mgr.f)localObject2).eNV.get(i);
        if (localWeakReference == null) {
          break label744;
        }
        f.a locala = (f.a)localWeakReference.get();
        if ((locala == null) || (!locala.equals(localObject1))) {
          break label744;
        }
        ((com.tencent.mm.plugin.card.mgr.f)localObject2).eNV.remove(localWeakReference);
      }
    }
    am.dkZ().release();
    this.uAL.cancel();
    dji();
    long l = System.currentTimeMillis() - this.mStartTime;
    if (this.wru != null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(13219, new Object[] { "CardDetailView", Integer.valueOf(this.lCR), this.wru.djP(), this.wru.djO(), Long.valueOf(l) });
      label607:
      if (((this.wzy) || (this.wzz)) && (this.wru != null) && (this.wru.djp()))
      {
        if (!this.wru.djC()) {
          break label804;
        }
        am.dkV().dJ(this.wrg, 2);
      }
      label663:
      localObject1 = this.wzI;
      Log.i("MicroMsg.CardLbsOrBluetooth", "uninit");
      if (((com.tencent.mm.plugin.card.mgr.h)localObject1).wrO != null)
      {
        localObject2 = ((com.tencent.mm.plugin.card.mgr.h)localObject1).wrO;
        if (((h.a)localObject2).rJV != null) {
          break label818;
        }
        Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.card.mgr.h)localObject1).wrO = null;
      ((com.tencent.mm.plugin.card.mgr.h)localObject1).dkq();
      ((com.tencent.mm.plugin.card.mgr.h)localObject1).wrT = null;
      ((com.tencent.mm.plugin.card.mgr.h)localObject1).wrG = null;
      super.onDestroy();
      AppMethodBeat.o(113218);
      return;
      label744:
      i += 1;
      break;
      com.tencent.mm.plugin.report.service.h.OAn.b(13219, new Object[] { "CardDetailView", Integer.valueOf(this.lCR), this.wrg, this.wrg, Long.valueOf(l) });
      break label607;
      label804:
      am.dkV().dJ(this.wrg, 1);
      break label663;
      label818:
      MMApplicationContext.getContext().unregisterReceiver(((h.a)localObject2).rJV);
      ((h.a)localObject2).rJV = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(113232);
    if (paramInt == 4)
    {
      Log.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
      D(false, -1);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(113232);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(113216);
    dlX();
    super.onPause();
    this.wzu.hJi = true;
    am.dkU().a(this, false);
    ScreenShotUtil.setScreenShotCallback(this, null);
    com.tencent.mm.plugin.card.mgr.h localh = this.wzI;
    if (localh.dkt())
    {
      Log.i("MicroMsg.CardLbsOrBluetooth", "stop");
      if (localh.wrO != null) {
        localh.wrO.dkw();
      }
      localh.dkq();
      com.tencent.mm.kernel.h.baD().mCm.b(2574, localh);
    }
    AppMethodBeat.o(113216);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(113238);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(113238);
      return;
    }
    Log.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113238);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        Log.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.wyi);
        if (!this.wyi)
        {
          this.wyi = true;
          this.owr = com.tencent.mm.modelgeo.d.bJl();
          djf();
        }
        AppMethodBeat.o(113238);
        return;
      }
      com.tencent.mm.ui.base.k.a(this, getString(a.g.permission_location_request_again_msg), getString(a.g.permission_tips_title), getString(a.g.jump_to_settings), getString(a.g.confirm_dialog_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(113211);
          com.tencent.mm.pluginsdk.permission.b.lx(CardDetailUI.this.getContext());
          AppMethodBeat.o(113211);
        }
      }, null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(113215);
    super.onResume();
    dlW();
    dmd();
    this.wzu.hJi = false;
    ScreenShotUtil.setScreenShotCallback(this, this);
    am.dkU().a(this, true);
    Object localObject;
    int i;
    if (((this.wzy) || (this.wzz)) && (this.wru.djp()))
    {
      if (!this.wru.djC()) {
        break label209;
      }
      am.dkV().dJ(this.wrg, 2);
      localObject = am.dkU();
      String str = this.wrg;
      localObject = (Boolean)((com.tencent.mm.plugin.card.mgr.c)localObject).wrt.get(str);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label193;
      }
      i = 1;
      if ((i == 0) || (TextUtils.isEmpty(am.dkU().wrw))) {
        break label198;
      }
      Log.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
      aku(am.dkU().wrw);
      label156:
      this.wzu.wzT.d(com.tencent.mm.plugin.card.c.c.wKm);
    }
    for (;;)
    {
      if (this.wzI.isInit) {
        this.wzI.start();
      }
      AppMethodBeat.o(113215);
      return;
      label193:
      i = 0;
      break;
      label198:
      Log.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
      break label156;
      label209:
      am.dkV().dJ(this.wrg, 1);
      localObject = this.wzu.wzT;
      if (localObject != null) {
        ((com.tencent.mm.plugin.card.ui.view.g)localObject).d(com.tencent.mm.plugin.card.c.c.wKm);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(113225);
    Log.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      na(false);
      this.bEx.setVisibility(8);
      Object localObject;
      if ((paramp instanceof aa))
      {
        paramString = ((aa)paramp).wuy;
        if (TextUtils.isEmpty(paramString))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramp = this.wru;
        localObject = new CardInfo();
        com.tencent.mm.plugin.card.c.f.a((CardInfo)localObject, paramString);
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).djO()))
        {
          this.wrg = ((com.tencent.mm.plugin.card.base.b)localObject).djO();
          this.wru = ((com.tencent.mm.plugin.card.base.b)localObject);
          dmb();
          if (this.lCR == 3)
          {
            if (paramp != null)
            {
              ((CardInfo)this.wru).field_stickyAnnouncement = ((CardInfo)paramp).field_stickyAnnouncement;
              ((CardInfo)this.wru).field_stickyEndTime = ((CardInfo)paramp).field_stickyEndTime;
              ((CardInfo)this.wru).field_stickyIndex = ((CardInfo)paramp).field_stickyIndex;
              ((CardInfo)this.wru).field_label_wording = ((CardInfo)paramp).field_label_wording;
              this.wru.a(paramp.djN());
            }
            if (!this.wzE) {
              break label405;
            }
            l.h(this.wru);
          }
        }
        for (;;)
        {
          dlx();
          dlZ();
          if (this.wru.djD()) {
            am.dkW().aks(this.wru.djO());
          }
          this.wzI.a(this, this.wrg, this.wru, this.lsz, this.lsA);
          AppMethodBeat.o(113225);
          return;
          if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject).djO())) || (this.wrg.equals(((com.tencent.mm.plugin.card.base.b)localObject).djP()))) {
            break;
          }
          Log.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.wrg, ((com.tencent.mm.plugin.card.base.b)localObject).djP() });
          AppMethodBeat.o(113225);
          return;
          label405:
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.model.o))
      {
        if (this.wxa == 26) {
          na(false);
        }
        localObject = ((com.tencent.mm.plugin.card.model.o)paramp).wuy;
        paramInt1 = ((com.tencent.mm.plugin.card.model.o)paramp).wuz;
        paramp = ((com.tencent.mm.plugin.card.model.o)paramp).wuA;
        if (paramInt1 != 0) {
          c(paramInt2, paramString, paramInt1, paramp);
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
          AppMethodBeat.o(113225);
          return;
          com.tencent.mm.ui.base.k.cZ(this, getResources().getString(a.g.wof));
        }
        this.lCR = 3;
        if (this.wru == null) {
          this.wru = new CardInfo();
        }
        com.tencent.mm.plugin.card.c.f.a((CardInfo)this.wru, (String)localObject);
        if (!TextUtils.isEmpty(this.wru.djO())) {
          this.wrg = this.wru.djO();
        }
        if (this.wzu.dmG() == 1)
        {
          paramString = this.wzu;
          if (paramString.wAh != null)
          {
            paramString = paramString.wAh;
            if (paramString.wrA != null) {
              paramString.wrA.wsK = false;
            }
          }
        }
        if (this.wxa != 26)
        {
          dmb();
          dlx();
        }
        l.doO();
        paramString = this.wru;
        if (paramString.djq())
        {
          paramp = (Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJA, Integer.valueOf(0));
          if ((paramp == null) || (paramp.intValue() != 1))
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acJA, Integer.valueOf(1));
            if (!l.doR()) {
              break label907;
            }
            com.tencent.mm.plugin.card.c.d.c(this, a.e.wnG, a.g.wod, paramString.djK().wtN);
          }
          label737:
          this.wzH = this.wru.djT();
          if ((this.wxa != 7) && (this.wxa != 16)) {
            break label929;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.wzH);
          setResult(-1, paramString);
          It(-1);
        }
        for (;;)
        {
          if (this.wru.djD()) {
            am.dkW().aks(this.wru.djO());
          }
          this.wzI.a(this, this.wrg, this.wru, this.lsz, this.lsA);
          AppMethodBeat.o(113225);
          return;
          paramp = (Integer)com.tencent.mm.kernel.h.baE().ban().d(282884, null);
          if ((paramp != null) && (paramp.intValue() == 1)) {
            break label737;
          }
          com.tencent.mm.kernel.h.baE().ban().B(282884, Integer.valueOf(1));
          break;
          label907:
          com.tencent.mm.plugin.card.c.d.c(this, a.e.wnF, a.g.woc, paramString.djK().wtN);
          break label737;
          label929:
          if ((!this.wzD) && (this.wxa == 8)) {
            D(true, -1);
          } else if ((this.wxa == 26) && (paramInt1 == 0)) {
            D(true, -1);
          }
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.model.v))
      {
        this.wrB = ((com.tencent.mm.plugin.card.model.v)paramp).wuG;
        if ((this.wru != null) && (this.wrB != null) && (this.wrB.size() > 0))
        {
          this.wru.a((wl)this.wrB.get(0));
          dlx();
          if (this.wru.djp())
          {
            paramString = am.dkR().akS(this.wrg);
            if (paramString != null)
            {
              paramString.a((wl)this.wrB.get(0));
              am.dkR().update(paramString, new String[] { this.wrg });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.dkJ().akC(this.wrg);
          if (paramString != null)
          {
            paramString.a((wl)this.wrB.get(0));
            am.dkJ().update(paramString, new String[] { this.wrg });
          }
          AppMethodBeat.o(113225);
          return;
        }
        if ((this.wru != null) && (this.wrB == null))
        {
          this.wru.a(null);
          dlx();
          if (this.wru.djp())
          {
            paramString = am.dkR().akS(this.wrg);
            if (paramString != null)
            {
              paramString.a(null);
              am.dkR().update(paramString, new String[] { this.wrg });
            }
            AppMethodBeat.o(113225);
            return;
          }
          paramString = am.dkJ().akC(this.wrg);
          if (paramString != null)
          {
            paramString.a(null);
            am.dkJ().update(paramString, new String[] { this.wrg });
          }
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramp instanceof af))
      {
        paramInt1 = ((af)paramp).wuz;
        localObject = ((af)paramp).wuA;
        if (paramInt1 == 10000)
        {
          paramString = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramString = getString(a.g.woI);
          }
          com.tencent.mm.plugin.card.c.d.b(this, paramString);
          AppMethodBeat.o(113225);
          return;
        }
        this.wzx = ((af)paramp).iaJ;
        nc(true);
        paramString = this.wru.djL();
        paramString.status = 3;
        this.wru.a(paramString);
        l.h(this.wru);
        dlx();
        if (this.wxa == 3)
        {
          D(true, 2);
          AppMethodBeat.o(113225);
          return;
        }
        if (this.wxa == 15) {
          new xf().publish();
        }
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramp instanceof r))
      {
        com.tencent.mm.ui.base.k.cZ(this, getResources().getString(a.g.wox));
        am.dkI();
        com.tencent.mm.plugin.card.mgr.a.Ih(4);
        D(true, 1);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramp instanceof t))
      {
        paramString = (t)paramp;
        paramp = paramString.wuE;
        if ((paramp != null) && (paramp.size() > 0))
        {
          paramp = (com.tencent.mm.plugin.card.base.b)paramp.get(0);
          if ((paramp != null) && (!this.wrg.equals(paramString.cardId)))
          {
            Log.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[] { this.wrg, paramString.cardId });
            AppMethodBeat.o(113225);
            return;
          }
          this.wru = paramp;
          if (this.wru != null)
          {
            this.wrg = this.wru.djO();
            dmb();
            if (this.wru.djD()) {
              am.dkW().aks(this.wru.djO());
            }
          }
          if (this.lCR == 26) {
            this.lCR = 3;
          }
          dlx();
        }
        dlZ();
        l.doO();
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.g))
      {
        paramString = ((com.tencent.mm.plugin.card.sharecard.model.g)paramp).wuy;
        paramInt1 = ((com.tencent.mm.plugin.card.sharecard.model.g)paramp).wuz;
        paramp = ((com.tencent.mm.plugin.card.sharecard.model.g)paramp).wuA;
        if (paramInt1 != 0)
        {
          paramString = paramp;
          if (TextUtils.isEmpty(paramp)) {
            paramString = getString(a.g.wnV);
          }
          com.tencent.mm.plugin.card.c.d.b(this, paramString);
          Log.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[] { paramString });
          AppMethodBeat.o(113225);
          return;
        }
        com.tencent.mm.ui.base.k.cZ(this, getResources().getString(a.g.wnY));
        if (TextUtils.isEmpty(paramString))
        {
          Log.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
          AppMethodBeat.o(113225);
          return;
        }
        this.lCR = 3;
        if (this.wru == null)
        {
          this.wru = new ShareCardInfo();
          com.tencent.mm.plugin.card.c.f.a((ShareCardInfo)this.wru, paramString);
          paramp = (ShareCardInfo)this.wru;
          if (!TextUtils.isEmpty(paramString)) {
            break label2142;
          }
          Log.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
          label1879:
          if (!TextUtils.isEmpty(this.wru.djO())) {
            this.wrg = this.wru.djO();
          }
          if (TextUtils.isEmpty(this.wru.djQ())) {
            ((ShareCardInfo)this.wru).field_from_username = z.bAM();
          }
          l.a((ShareCardInfo)this.wru);
          dmb();
          dlx();
          l.doQ();
          am.dkQ().onChange();
          this.wzH = this.wru.djT();
          if ((this.wxa != 7) && (this.wxa != 16)) {
            break label2234;
          }
          paramString = new Intent();
          paramString.putExtra("key_code", this.wzH);
          setResult(-1, paramString);
          It(-1);
        }
        for (;;)
        {
          for (;;)
          {
            paramString = (Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJy, Integer.valueOf(0));
            if ((paramString == null) || (paramString.intValue() != 1))
            {
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acJy, Integer.valueOf(1));
              com.tencent.mm.plugin.card.c.d.c(this, a.e.wnI, a.g.wqe, "");
            }
            if (this.wru.djD()) {
              am.dkW().aks(this.wru.djO());
            }
            AppMethodBeat.o(113225);
            return;
            if (!(this.wru instanceof CardInfo)) {
              break;
            }
            this.wru = new ShareCardInfo();
            break;
            try
            {
              label2142:
              paramString = new JSONObject(paramString).optJSONArray("card_list");
              if (paramString == null) {
                break label1879;
              }
              paramp.wsB = paramString.optJSONObject(0).optString("encrypt_code");
              Log.i("MicroMsg.CardInfoParser", "encrypt_code:" + paramp.wsB);
            }
            catch (JSONException paramString)
            {
              Log.printErrStackTrace("MicroMsg.CardInfoParser", paramString, "", new Object[0]);
              Log.e("MicroMsg.CardInfoParser", paramString.getMessage());
            }
          }
          break label1879;
          label2234:
          if ((!this.wzD) && (this.wxa == 8)) {
            D(true, -1);
          }
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.c))
      {
        paramp = ((com.tencent.mm.plugin.card.sharecard.model.c)paramp).wuy;
        if (TextUtils.isEmpty(paramp))
        {
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
          AppMethodBeat.o(113225);
          return;
        }
        paramString = this.wru;
        this.wru = new ShareCardInfo();
        localObject = (ShareCardInfo)this.wru;
        if (TextUtils.isEmpty(paramp))
        {
          Log.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
          if (paramString != null)
          {
            if (!TextUtils.isEmpty(paramString.djQ())) {
              ((ShareCardInfo)this.wru).field_from_username = ((ShareCardInfo)paramString).field_from_username;
            }
            ((ShareCardInfo)this.wru).field_app_id = ((ShareCardInfo)paramString).field_app_id;
            ((ShareCardInfo)this.wru).field_consumer = ((ShareCardInfo)paramString).field_consumer;
            ((ShareCardInfo)this.wru).field_share_time = ((ShareCardInfo)paramString).field_share_time;
            ((ShareCardInfo)this.wru).field_updateTime = ((ShareCardInfo)paramString).field_updateTime;
            ((ShareCardInfo)this.wru).field_begin_time = ((ShareCardInfo)paramString).field_begin_time;
            ((ShareCardInfo)this.wru).field_end_time = ((ShareCardInfo)paramString).field_end_time;
            ((ShareCardInfo)this.wru).field_block_mask = ((ShareCardInfo)paramString).field_block_mask;
            this.wru.a(paramString.djN());
            ((ShareCardInfo)this.wru).field_categoryType = ((ShareCardInfo)paramString).field_categoryType;
            ((ShareCardInfo)this.wru).field_itemIndex = ((ShareCardInfo)paramString).field_itemIndex;
            if (((ShareCardInfo)paramString).field_status != ((ShareCardInfo)this.wru).field_status)
            {
              Log.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo)this.wru).field_status);
              com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.wru);
            }
          }
          if (!TextUtils.isEmpty(this.wru.djO())) {
            this.wrg = this.wru.djO();
          }
          dlx();
          dmb();
          dlZ();
          if (this.lCR == 3)
          {
            if (!this.wzE) {
              break label2735;
            }
            l.h(this.wru);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (this.wru.djD()) {
              am.dkW().aks(this.wru.djO());
            }
            AppMethodBeat.o(113225);
            return;
            try
            {
              com.tencent.mm.plugin.card.c.f.a((ShareCardInfo)localObject, new JSONObject(paramp));
            }
            catch (JSONException paramp)
            {
              Log.printErrStackTrace("MicroMsg.CardInfoParser", paramp, "", new Object[0]);
            }
          }
          break;
          label2735:
          Log.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
        }
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.sharecard.model.a))
      {
        if (((com.tencent.mm.plugin.card.sharecard.model.a)paramp).wuz != 0)
        {
          com.tencent.mm.plugin.card.c.d.b(this, getString(a.g.wov));
          AppMethodBeat.o(113225);
          return;
        }
        Log.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.wru.djO());
        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.wru);
        com.tencent.mm.ui.base.k.cZ(this, getResources().getString(a.g.wox));
        am.dkQ().dln();
        D(true, -1);
        AppMethodBeat.o(113225);
      }
    }
    else
    {
      Log.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + paramInt1 + " errCode = " + paramInt2 + " cmd:" + paramp.getType());
      na(false);
      if (!(paramp instanceof af)) {
        break label3003;
      }
      nc(false);
      paramInt1 = ((af)paramp).wuz;
      paramp = ((af)paramp).wuA;
      if (paramInt1 != 10000) {
        break label3060;
      }
      paramString = paramp;
      if (TextUtils.isEmpty(paramp)) {
        paramString = getString(a.g.woI);
      }
    }
    label3003:
    label3060:
    for (;;)
    {
      paramp = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramp = getString(a.g.wqJ);
      }
      Toast.makeText(getContext(), paramp, 0).show();
      AppMethodBeat.o(113225);
      return;
      if ((paramp instanceof com.tencent.mm.plugin.card.model.o))
      {
        It(0);
        c(paramInt2, paramString, ((com.tencent.mm.plugin.card.model.o)paramp).wuz, ((com.tencent.mm.plugin.card.model.o)paramp).wuA);
        AppMethodBeat.o(113225);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.card.model.v))
      {
        AppMethodBeat.o(113225);
        return;
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(293811);
    paramString = this.wzu.wzT;
    if (paramString != null) {
      paramString.ddE();
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(16827, new Object[] { this.wrg, Long.valueOf(System.currentTimeMillis() / 1000L) });
    AppMethodBeat.o(293811);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(113250);
    if ((this.wzu.wzT instanceof q))
    {
      ((q)this.wzu.wzT).wEh = am.dkW().getCode();
      this.wzu.dlx();
    }
    Log.i("MicroMsg.CardDetailUI", "code get success");
    AppMethodBeat.o(113250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(293839);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(CardDetailUI.a.class);
    AppMethodBeat.o(293839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardDetailUI
 * JD-Core Version:    0.7.0.1
 */