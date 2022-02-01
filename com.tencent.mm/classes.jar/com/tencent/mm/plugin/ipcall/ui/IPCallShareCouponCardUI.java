package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI
  extends MMActivity
  implements f, a.a, com.tencent.mm.ui.k.a.b
{
  private ProgressDialog fMu;
  private String mDesc;
  private int mFrom;
  private String mTitle;
  private String mWording;
  private View mwQ;
  private ProgressDialog sBI;
  private ProgressDialog uQp;
  private ImageView uTA;
  private ProgressBar uTB;
  private e uTC;
  private String uTD;
  private String uTE;
  private String uTF;
  private String uTG;
  private String uTH;
  private String uTI;
  private String uTJ;
  private String uTK;
  private ear uTL;
  private String uTM;
  private View uTN;
  private TextView uTs;
  private TextView uTt;
  private TextView uTu;
  private TextView uTv;
  private Button uTw;
  private ImageView uTx;
  private com.tencent.mm.ui.k.a uTy;
  private i uTz;
  
  public IPCallShareCouponCardUI()
  {
    AppMethodBeat.i(25917);
    this.uTy = new com.tencent.mm.ui.k.a();
    this.fMu = null;
    this.sBI = null;
    this.uTz = null;
    this.uQp = null;
    this.uTA = null;
    this.uTB = null;
    this.uTC = new e();
    this.uTD = null;
    this.mDesc = null;
    this.uTE = null;
    this.mTitle = null;
    this.mWording = null;
    this.uTF = null;
    this.uTG = null;
    this.uTH = null;
    this.uTI = null;
    this.uTJ = null;
    this.uTK = null;
    this.uTL = null;
    this.uTM = null;
    this.mFrom = 0;
    AppMethodBeat.o(25917);
  }
  
  private void B(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(25930);
    this.uTN = View.inflate(getContext(), 2131493586, null);
    final EditText localEditText = (EditText)this.uTN.findViewById(2131298569);
    this.uTA = ((ImageView)this.uTN.findViewById(2131298566));
    this.uTB = ((ProgressBar)this.uTN.findViewById(2131301506));
    localEditText.setText(paramString1);
    Object localObject = deH();
    if (localObject == null)
    {
      localObject = u.aAm();
      ba.aBQ();
      localObject = new com.tencent.mm.bd.a((String)localObject, bt.n((Integer)com.tencent.mm.model.c.ajl().get(66561, null)));
      ba.aiU().a((n)localObject, 0);
      this.uTB.setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.uTN, getResources().getString(2131755884), new y.b()
      {
        public final void nO(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25906);
          if (paramAnonymousBoolean)
          {
            if (localEditText == null) {}
            for (Object localObject = paramString1;; localObject = localEditText.getText().toString())
            {
              localObject = new com.tencent.mm.modelmulti.h(paramInt, (String)localObject);
              IPCallShareCouponCardUI localIPCallShareCouponCardUI1 = IPCallShareCouponCardUI.this;
              IPCallShareCouponCardUI localIPCallShareCouponCardUI2 = IPCallShareCouponCardUI.this;
              IPCallShareCouponCardUI.this.getString(2131755906);
              IPCallShareCouponCardUI.b(localIPCallShareCouponCardUI1, com.tencent.mm.ui.base.h.b(localIPCallShareCouponCardUI2, IPCallShareCouponCardUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(25905);
                  ba.aiU().a(this.uTR);
                  AppMethodBeat.o(25905);
                }
              }));
              ba.aiU().a((n)localObject, 0);
              AppMethodBeat.o(25906);
              return;
            }
          }
          AppMethodBeat.o(25906);
        }
      });
      AppMethodBeat.o(25930);
      return;
      if (this.uTA != null) {
        this.uTA.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  public static int IM(int paramInt)
  {
    AppMethodBeat.i(25924);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), Integer.valueOf(2131689791));
    localHashMap.put(Integer.valueOf(0), Integer.valueOf(2131689838));
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(2131689837));
    localHashMap.put(Integer.valueOf(3), Integer.valueOf(2131689792));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(2131689839));
    localHashMap.put(Integer.valueOf(5), Integer.valueOf(2131689840));
    localHashMap.put(Integer.valueOf(4), Integer.valueOf(2131689841));
    localHashMap.put(Integer.valueOf(6), Integer.valueOf(2131689793));
    localHashMap.put(Integer.valueOf(7), Integer.valueOf(2131689836));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
      AppMethodBeat.o(25924);
      return paramInt;
    }
    AppMethodBeat.o(25924);
    return -1;
  }
  
  private void IN(int paramInt)
  {
    AppMethodBeat.i(25927);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25927);
  }
  
  public static void a(Context paramContext, int paramInt, TextView paramTextView, ImageView paramImageView)
  {
    AppMethodBeat.i(25922);
    paramContext = ad(paramContext, paramInt);
    if (paramContext != null) {
      paramTextView.setText(paramContext);
    }
    paramInt = IM(paramInt);
    if (paramInt != -1) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(25922);
  }
  
  public static String ad(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(25923);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), paramContext.getString(2131760485));
    localHashMap.put(Integer.valueOf(0), paramContext.getString(2131766188));
    localHashMap.put(Integer.valueOf(1), paramContext.getString(2131760490));
    localHashMap.put(Integer.valueOf(3), paramContext.getString(2131760486));
    localHashMap.put(Integer.valueOf(2), paramContext.getString(2131760489));
    localHashMap.put(Integer.valueOf(5), paramContext.getString(2131760491));
    localHashMap.put(Integer.valueOf(4), paramContext.getString(2131760492));
    localHashMap.put(Integer.valueOf(6), paramContext.getString(2131760488));
    localHashMap.put(Integer.valueOf(7), paramContext.getString(2131760487));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramContext = (String)localHashMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(25923);
      return paramContext;
    }
    AppMethodBeat.o(25923);
    return null;
  }
  
  /* Error */
  private static byte[] anS(String paramString)
  {
    // Byte code:
    //   0: sipush 25929
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 192	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 673	com/tencent/mm/model/c:azA	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 192	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 676	com/tencent/mm/model/c:azB	()Ljava/lang/String;
    //   22: ldc_w 678
    //   25: aload_0
    //   26: invokevirtual 682	java/lang/String:getBytes	()[B
    //   29: invokestatic 688	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 690
    //   35: invokestatic 696	com/tencent/mm/sdk/platformtools/m:j	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: invokestatic 700	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   43: ifeq +20 -> 63
    //   46: ldc_w 306
    //   49: ldc_w 702
    //   52: invokestatic 647	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: sipush 25929
    //   58: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aconst_null
    //   62: areturn
    //   63: aload_0
    //   64: iconst_0
    //   65: invokestatic 708	com/tencent/mm/vfs/i:dd	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   68: astore_1
    //   69: aload_1
    //   70: astore_0
    //   71: aload_1
    //   72: invokevirtual 714	java/io/RandomAccessFile:length	()J
    //   75: l2i
    //   76: newarray byte
    //   78: astore_2
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: aload_2
    //   83: invokevirtual 718	java/io/RandomAccessFile:read	([B)I
    //   86: pop
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 721	java/io/RandomAccessFile:close	()V
    //   95: sipush 25929
    //   98: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_2
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: ldc_w 306
    //   111: aload_2
    //   112: ldc_w 509
    //   115: iconst_0
    //   116: anewarray 437	java/lang/Object
    //   119: invokestatic 725	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 721	java/io/RandomAccessFile:close	()V
    //   130: sipush 25929
    //   133: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 721	java/io/RandomAccessFile:close	()V
    //   149: sipush 25929
    //   152: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_1
    //   156: athrow
    //   157: astore_0
    //   158: goto -63 -> 95
    //   161: astore_0
    //   162: goto -32 -> 130
    //   165: astore_0
    //   166: goto -17 -> 149
    //   169: astore_1
    //   170: goto -29 -> 141
    //   173: astore_2
    //   174: goto -68 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	String
    //   13	114	1	localObject1	Object
    //   138	18	1	localObject2	Object
    //   169	1	1	localObject3	Object
    //   78	24	2	arrayOfByte	byte[]
    //   103	9	2	localException1	java.lang.Exception
    //   173	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   63	69	103	java/lang/Exception
    //   63	69	138	finally
    //   91	95	157	java/lang/Exception
    //   126	130	161	java/lang/Exception
    //   145	149	165	java/lang/Exception
    //   71	79	169	finally
    //   81	87	169	finally
    //   108	122	169	finally
    //   71	79	173	java/lang/Exception
    //   81	87	173	java/lang/Exception
  }
  
  private static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(25925);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25925);
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      AppMethodBeat.o(25925);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(25925);
    }
    return false;
  }
  
  private static Bitmap deH()
  {
    AppMethodBeat.i(25928);
    Object localObject = anS(u.aAm());
    if (localObject == null)
    {
      AppMethodBeat.o(25928);
      return null;
    }
    localObject = com.tencent.mm.sdk.platformtools.g.cr((byte[])localObject);
    AppMethodBeat.o(25928);
    return localObject;
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(25926);
    if (this.sBI != null) {
      this.sBI.cancel();
    }
    switch (IPCallShareCouponCardUI.8.uTV[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25926);
      return;
      IN(2131764543);
      AppMethodBeat.o(25926);
      return;
      AppMethodBeat.o(25926);
      return;
      IN(2131764542);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494504;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(25931);
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!bt.isNullOrNil(paramIntent)) {
        o.a(getController(), this.mTitle, this.uTE, this.mDesc, true, getResources().getString(2131755884), new y.a()
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(25909);
            if (paramAnonymousBoolean)
            {
              Object localObject = new k.b();
              ((k.b)localObject).title = IPCallShareCouponCardUI.d(IPCallShareCouponCardUI.this);
              ((k.b)localObject).url = IPCallShareCouponCardUI.e(IPCallShareCouponCardUI.this);
              ((k.b)localObject).description = IPCallShareCouponCardUI.f(IPCallShareCouponCardUI.this);
              ((k.b)localObject).thumburl = IPCallShareCouponCardUI.g(IPCallShareCouponCardUI.this);
              ((k.b)localObject).type = 5;
              m.a((k.b)localObject, null, null, paramIntent, "", null, null);
              if (!bt.isNullOrNil(paramAnonymousString))
              {
                localObject = new sx();
                ((sx)localObject).dHy.dHz = paramIntent;
                ((sx)localObject).dHy.content = paramAnonymousString;
                ((sx)localObject).dHy.type = w.Ar(paramIntent);
                ((sx)localObject).dHy.flags = 0;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
              }
              com.tencent.mm.ui.base.h.cl(IPCallShareCouponCardUI.this.getContext(), IPCallShareCouponCardUI.this.getResources().getString(2131755894));
              AppMethodBeat.o(25909);
              return;
            }
            AppMethodBeat.o(25909);
          }
        });
      }
    }
    AppMethodBeat.o(25931);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25918);
    super.onCreate(paramBundle);
    setMMTitle(2131760558);
    setBackBtn(new IPCallShareCouponCardUI.1(this));
    this.mwQ = findViewById(2131301339);
    this.uTs = ((TextView)findViewById(2131298810));
    this.uTt = ((TextView)findViewById(2131298927));
    this.uTu = ((TextView)findViewById(2131298809));
    this.uTv = ((TextView)findViewById(2131298811));
    this.uTw = ((Button)findViewById(2131304737));
    this.uTx = ((ImageView)findViewById(2131300718));
    this.mwQ.setVisibility(8);
    com.tencent.mm.pluginsdk.ui.a.b.a(this.uTx, u.aAm(), 0.5F, false);
    paramBundle = getContext();
    getString(2131755906);
    this.uQp = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131760457), true, new IPCallShareCouponCardUI.9(this));
    com.tencent.mm.plugin.ipcall.model.g.b.dei().nL(false);
    this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
    ba.aiU().a(257, this);
    ba.aiU().a(1804, this);
    AppMethodBeat.o(25918);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25920);
    super.onDestroy();
    ba.aiU().b(257, this);
    ba.aiU().b(1804, this);
    AppMethodBeat.o(25920);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25919);
    super.onResume();
    AppMethodBeat.o(25919);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25921);
    String str;
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.mwQ.setVisibility(0);
        paramString = com.tencent.mm.plugin.ipcall.a.c.dfi();
        if (paramString != null)
        {
          this.uTD = paramString.GFm;
          this.mDesc = paramString.Desc;
          this.uTE = paramString.GFn;
          this.mTitle = paramString.Title;
          this.mWording = paramString.uOt;
          this.uTF = paramString.GFo;
          this.uTH = paramString.GFp;
          this.uTI = paramString.GFq;
          this.uTJ = paramString.GFr;
          this.uTK = paramString.GFt;
          this.uTL = paramString.GFs;
          this.uTM = paramString.GFu;
        }
        this.uTs.setText(this.uTK);
        this.uTt.setText(String.format(getContext().getString(2131760551), new Object[] { this.uTD }));
        this.uTw.setOnClickListener(new IPCallShareCouponCardUI.11(this));
        this.uTu.setText(String.format(getString(2131760553), new Object[] { this.uTK }));
        paramn = this.uTv;
        str = String.format(getString(2131760552), new Object[] { this.uTK });
        localObject1 = getString(2131760557);
        if (bt.isNullOrNil((String)localObject1))
        {
          paramn.setText(str);
          if ((this.uQp != null) && (this.uQp.isShowing())) {
            this.uQp.dismiss();
          }
          AppMethodBeat.o(25921);
          return;
        }
        paramString = getString(2131760560);
        localObject2 = paramn.getPaint();
        float f1 = ((TextPaint)localObject2).measureText(str);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        paramInt1 = com.tencent.mm.cc.a.ip(getContext());
        paramInt2 = ((LinearLayout.LayoutParams)paramn.getLayoutParams()).leftMargin;
        paramInt1 -= ((LinearLayout.LayoutParams)paramn.getLayoutParams()).rightMargin + paramInt2;
        paramInt2 = (int)Math.ceil(f1 / paramInt1);
        int i = (int)Math.ceil((f1 + f2) / paramInt1);
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = 1;
        }
        if (i <= paramInt1) {
          break label743;
        }
        paramString = "\n".concat(String.valueOf(paramString));
      }
    }
    label743:
    for (;;)
    {
      paramn.setGravity(17);
      localObject2 = Spannable.Factory.getInstance().newSpannable(str + paramString);
      localObject1 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25907);
          ((TextView)paramAnonymousView).setHighlightColor(IPCallShareCouponCardUI.this.getResources().getColor(2131101053));
          com.tencent.mm.plugin.report.service.g.yhR.f(13340, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1) });
          com.tencent.mm.ui.base.h.c(IPCallShareCouponCardUI.this.getContext(), this.uTT, IPCallShareCouponCardUI.this.getString(2131760561), true).a(2131760433, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(25907);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(25908);
          paramAnonymousTextPaint.setColor(IPCallShareCouponCardUI.this.getResources().getColor(2131100547));
          paramAnonymousTextPaint.setUnderlineText(false);
          AppMethodBeat.o(25908);
        }
      };
      paramInt1 = str.length();
      paramInt2 = str.length();
      ((Spannable)localObject2).setSpan(localObject1, paramInt1, paramString.length() + paramInt2, 33);
      paramn.setText((CharSequence)localObject2);
      paramn.setMovementMethod(LinkMovementMethod.getInstance());
      break;
      if ((this.uQp != null) && (this.uQp.isShowing()))
      {
        this.uQp.dismiss();
        com.tencent.mm.ui.base.h.d(getContext(), getString(2131760455), getString(2131760448), new IPCallShareCouponCardUI.10(this));
        AppMethodBeat.o(25921);
        return;
        if ((paramn instanceof com.tencent.mm.modelmulti.h))
        {
          if (this.fMu != null)
          {
            this.fMu.dismiss();
            this.fMu = null;
          }
          if (com.tencent.mm.plugin.subapp.b.iRH.b(getContext(), paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            com.tencent.mm.ui.base.h.l(getContext(), 2131763075, 2131755906);
            AppMethodBeat.o(25921);
            return;
          }
          com.tencent.mm.ui.base.h.cl(this, getResources().getString(2131757561));
          AppMethodBeat.o(25921);
          return;
        }
        if ((paramn instanceof com.tencent.mm.bd.a))
        {
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if (this.uTA != null)
          {
            if (this.uTB != null) {
              this.uTB.setVisibility(8);
            }
            this.uTA.setImageBitmap(deH());
          }
        }
      }
      AppMethodBeat.o(25921);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI
 * JD-Core Version:    0.7.0.1
 */