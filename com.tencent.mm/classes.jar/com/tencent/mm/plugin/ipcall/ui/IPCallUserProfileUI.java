package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.f.d;
import java.util.ArrayList;
import java.util.LinkedList;

public class IPCallUserProfileUI
  extends MMActivity
{
  private boolean DUA;
  private TextView DYR;
  private TextView DYS;
  private LinearLayout DYT;
  private LinearLayout DYU;
  private TextView DYV;
  private TextView DYW;
  private TextView DYX;
  private TextView DYY;
  private TextView DYZ;
  private Button DZa;
  private String DZb;
  private String DZc;
  private Bitmap DZd;
  private boolean DZe;
  private Cursor DZf;
  private boolean DZg;
  private e DZh;
  private String fVa;
  private String fXl;
  private ImageView jiu;
  
  public IPCallUserProfileUI()
  {
    AppMethodBeat.i(26007);
    this.DUA = false;
    this.DZf = null;
    this.DZg = false;
    this.DZh = new e();
    AppMethodBeat.o(26007);
  }
  
  private void a(k paramk, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26014);
    View localView = LayoutInflater.from(this).inflate(R.i.eki, this.DYU, false);
    TextView localTextView1 = (TextView)localView.findViewById(R.h.dRx);
    TextView localTextView2 = (TextView)localView.findViewById(R.h.dRz);
    TextView localTextView3 = (TextView)localView.findViewById(R.h.dRA);
    localTextView2.setText(com.tencent.mm.plugin.ipcall.a.a.aMH(paramk.field_phonenumber));
    if (paramk.field_duration > 0L) {
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.On(paramk.field_duration));
    }
    for (;;)
    {
      localTextView1.setText(com.tencent.mm.plugin.ipcall.a.c.Oj(paramk.field_calltime));
      if (paramBoolean)
      {
        localView.setBackgroundDrawable(getResources().getDrawable(R.g.dov));
        int i = getResources().getDimensionPixelSize(R.f.dly);
        localView.setPadding(i, 0, i, 0);
      }
      if (1 == paramInt)
      {
        paramk = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramk.height = com.tencent.mm.ci.a.aY(getContext(), R.f.dlx);
        localView.setLayoutParams(paramk);
      }
      this.DYU.addView(localView);
      AppMethodBeat.o(26014);
      return;
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.VA(paramk.field_status));
    }
  }
  
  /* Error */
  private static String aMw(String paramString)
  {
    // Byte code:
    //   0: sipush 26011
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 307	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: ldc_w 309
    //   12: invokestatic 314	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   15: ifne +20 -> 35
    //   18: ldc_w 316
    //   21: ldc_w 318
    //   24: invokestatic 324	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: sipush 26011
    //   30: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: areturn
    //   35: invokestatic 307	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   38: invokevirtual 330	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: getstatic 336	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   44: aconst_null
    //   45: ldc_w 338
    //   48: iconst_1
    //   49: anewarray 340	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: aastore
    //   56: aconst_null
    //   57: invokevirtual 346	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnonnull +11 -> 75
    //   67: sipush 26011
    //   70: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload 4
    //   77: invokeinterface 352 1 0
    //   82: istore_1
    //   83: iload_1
    //   84: ifeq +152 -> 236
    //   87: ldc_w 354
    //   90: astore_0
    //   91: aload_0
    //   92: astore_2
    //   93: aload_0
    //   94: astore_3
    //   95: aload 4
    //   97: invokeinterface 357 1 0
    //   102: ifne +138 -> 240
    //   105: aload_0
    //   106: astore_2
    //   107: aload 4
    //   109: aload 4
    //   111: ldc_w 359
    //   114: invokeinterface 363 2 0
    //   119: invokeinterface 366 2 0
    //   124: astore_3
    //   125: aload_0
    //   126: astore_2
    //   127: new 368	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 369	java/lang/StringBuilder:<init>	()V
    //   134: aload_0
    //   135: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 375
    //   145: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 379	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_0
    //   152: aload_0
    //   153: astore_2
    //   154: aload 4
    //   156: invokeinterface 382 1 0
    //   161: pop
    //   162: goto -71 -> 91
    //   165: astore_0
    //   166: ldc_w 316
    //   169: ldc_w 384
    //   172: iconst_2
    //   173: anewarray 264	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokevirtual 387	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload_0
    //   186: invokevirtual 391	java/lang/Object:getClass	()Ljava/lang/Class;
    //   189: invokevirtual 396	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 399	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 4
    //   198: invokeinterface 402 1 0
    //   203: aload_2
    //   204: astore_0
    //   205: aload_2
    //   206: ldc_w 375
    //   209: invokevirtual 405	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   212: iflt +16 -> 228
    //   215: aload_2
    //   216: iconst_0
    //   217: aload_2
    //   218: ldc_w 375
    //   221: invokevirtual 405	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   224: invokevirtual 409	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore_0
    //   228: sipush 26011
    //   231: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: areturn
    //   236: ldc_w 354
    //   239: astore_3
    //   240: aload 4
    //   242: invokeinterface 402 1 0
    //   247: aload_3
    //   248: astore_2
    //   249: goto -46 -> 203
    //   252: astore_0
    //   253: aload 4
    //   255: invokeinterface 402 1 0
    //   260: sipush 26011
    //   263: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: ldc_w 354
    //   272: astore_2
    //   273: goto -107 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   82	2	1	bool	boolean
    //   92	181	2	localObject	Object
    //   94	154	3	str	String
    //   60	194	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   95	105	165	java/lang/Exception
    //   107	125	165	java/lang/Exception
    //   127	152	165	java/lang/Exception
    //   154	162	165	java/lang/Exception
    //   75	83	252	finally
    //   95	105	252	finally
    //   107	125	252	finally
    //   127	152	252	finally
    //   154	162	252	finally
    //   166	196	252	finally
    //   75	83	268	java/lang/Exception
  }
  
  private void eKr()
  {
    int i = 0;
    AppMethodBeat.i(26009);
    ArrayList localArrayList = new ArrayList();
    if ((this.DZf != null) && (this.DZf.getCount() > 0))
    {
      for (;;)
      {
        try
        {
          if ((!this.DZf.moveToFirst()) || (this.DZf.isAfterLast())) {
            break label224;
          }
          i += 1;
          str = this.DZf.getString(this.DZf.getColumnIndex("data1"));
          j = this.DZf.getInt(this.DZf.getColumnIndex("data2"));
          if (!localArrayList.contains(str))
          {
            localArrayList.add(str);
            if (i != this.DZf.getCount()) {
              continue;
            }
            u(str, j, false);
          }
        }
        catch (Exception localException)
        {
          String str;
          int j;
          Log.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[] { localException.getMessage() });
          return;
          u(str, j, true);
          continue;
        }
        finally
        {
          this.DZf.close();
          AppMethodBeat.o(26009);
        }
        this.DZf.moveToNext();
      }
      label224:
      this.DZf.close();
      AppMethodBeat.o(26009);
      return;
    }
    this.DYT.setVisibility(8);
    AppMethodBeat.o(26009);
  }
  
  private void eKs()
  {
    AppMethodBeat.i(26012);
    this.DZa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26004);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).start();
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).DRZ = 1L;
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).DSa = 5L;
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).finish();
        com.tencent.mm.plugin.report.service.h.IzE.a(12766, new Object[] { Integer.valueOf(3) });
        if (!Util.isNullOrNil(IPCallUserProfileUI.e(IPCallUserProfileUI.this)))
        {
          localObject = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.aMx(IPCallUserProfileUI.e(IPCallUserProfileUI.this))));
          ((Intent)localObject).putExtra("sms_body", IPCallUserProfileUI.this.getString(R.l.eIM, new Object[] { z.bdN().ayr() }));
          paramAnonymousView = IPCallUserProfileUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26004);
          return;
          if (!Util.isNullOrNil(IPCallUserProfileUI.f(IPCallUserProfileUI.this)))
          {
            localObject = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.f(IPCallUserProfileUI.this)));
            ((Intent)localObject).putExtra("sms_body", IPCallUserProfileUI.this.getString(R.l.eIM, new Object[] { z.bdN().ayr() }));
            paramAnonymousView = IPCallUserProfileUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    });
    AppMethodBeat.o(26012);
  }
  
  private void eKt()
  {
    AppMethodBeat.i(26013);
    if (!this.DZg)
    {
      this.DYU.setVisibility(8);
      this.DYY.setVisibility(8);
    }
    Cursor localCursor;
    if (!Util.isNullOrNil(this.fXl))
    {
      localCursor = m.aMi(this.fXl);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label262;
      }
    }
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          int i = 0;
          j = i;
          if (!localCursor.isAfterLast())
          {
            k localk = new k();
            localk.convertFrom(localCursor);
            i += 1;
            if (i < 3) {
              break label287;
            }
            bool = true;
            a(localk, bool, localCursor.getCount());
            j = i;
            if (!bool)
            {
              localCursor.moveToNext();
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        int j;
        Log.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", new Object[] { localException.getMessage() });
        return;
        localCursor = i.eJx().aMg(this.fVa);
        break;
        if (j <= 0)
        {
          this.DYU.setVisibility(8);
          return;
        }
        if (localCursor.getCount() < 4) {
          continue;
        }
        eKu();
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(26013);
      }
      label262:
      this.DYU.setVisibility(8);
      this.DYY.setVisibility(8);
      AppMethodBeat.o(26013);
      return;
      label287:
      boolean bool = false;
    }
  }
  
  private void eKu()
  {
    AppMethodBeat.i(26015);
    View localView = LayoutInflater.from(this).inflate(R.i.ekj, this.DYU, false);
    this.DYU.addView(localView);
    localView.setOnClickListener(new IPCallUserProfileUI.3(this));
    AppMethodBeat.o(26015);
  }
  
  private void u(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26010);
    View localView = LayoutInflater.from(this).inflate(R.i.ekg, this.DYT, false);
    Object localObject = (LinearLayout)localView.findViewById(R.h.dLr);
    if (!paramBoolean) {
      ((LinearLayout)localObject).setBackgroundDrawable(null);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(R.h.dRe);
      TextView localTextView = (TextView)localView.findViewById(R.h.dRd);
      localTextView.setText(com.tencent.mm.plugin.ipcall.a.a.aMH(com.tencent.mm.plugin.ipcall.a.c.trimPhoneNumber(paramString)));
      ((TextView)localObject).setText(com.tencent.mm.plugin.ipcall.a.a.Vz(paramInt));
      localView.setClickable(true);
      localView.setOnClickListener(new IPCallUserProfileUI.4(this, paramString));
      localView.setOnLongClickListener(new IPCallUserProfileUI.5(this, localTextView));
      this.DYT.addView(localView);
      AppMethodBeat.o(26010);
      return;
      ((LinearLayout)localObject).setBackgroundDrawable(getResources().getDrawable(R.g.list_item_normal));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.ehU;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26017);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(26017);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26008);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.IzE.a(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    setBackBtn(new IPCallUserProfileUI.1(this));
    setMMTitle(R.l.eIX);
    this.jiu = ((ImageView)findViewById(R.h.avatar_iv));
    this.DYR = ((TextView)findViewById(R.h.dVY));
    this.DYS = ((TextView)findViewById(R.h.eaR));
    this.DYT = ((LinearLayout)findViewById(R.h.dRw));
    this.DYV = ((TextView)findViewById(R.h.dRv));
    this.DYX = ((TextView)findViewById(R.h.dRu));
    this.DYW = ((TextView)findViewById(R.h.dRt));
    this.DYU = ((LinearLayout)findViewById(R.h.dRy));
    this.DYY = ((TextView)findViewById(R.h.dSC));
    this.DYZ = ((TextView)findViewById(R.h.dJp));
    this.DZa = ((Button)findViewById(R.h.dRs));
    this.fXl = getIntent().getStringExtra("IPCallProfileUI_contactid");
    this.DZb = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
    this.DZc = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
    this.fVa = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
    this.DZg = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
    if (!Util.isNullOrNil(this.fXl))
    {
      this.DZd = com.tencent.mm.plugin.ipcall.a.a.bp(this, this.fXl);
      if (this.DZd != null) {
        this.jiu.setImageBitmap(this.DZd);
      }
    }
    if ((this.DZd == null) && (!Util.isNullOrNil(this.DZc)))
    {
      this.DZd = com.tencent.mm.am.d.a(this.DZc, false, -1, null);
      if (this.DZd != null) {
        this.jiu.setImageBitmap(this.DZd);
      }
    }
    if (!Util.isNullOrNil(this.DZb))
    {
      this.DYR.setText(this.DZb);
      if ((Util.isNullOrNil(this.DZc)) || (this.DZc.endsWith("@stranger"))) {
        break label541;
      }
      paramBundle = getString(R.l.eIY, new Object[] { aa.PJ(this.DZc) });
      this.DYS.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramBundle));
    }
    label541:
    boolean bool;
    for (;;)
    {
      if (!Util.isNullOrNil(this.fXl))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
        {
          Log.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
          AppMethodBeat.o(26008);
          return;
          if (Util.isNullOrNil(this.fVa)) {
            break;
          }
          this.DYR.setText(com.tencent.mm.plugin.ipcall.a.a.aMH(this.fVa));
          break;
          this.DYS.setVisibility(8);
          continue;
        }
        this.DZf = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[] { this.fXl }, null);
        if (this.DZf.getCount() > 1) {
          break label747;
        }
        bool = true;
        this.DUA = bool;
      }
    }
    eKt();
    this.DYX.setVisibility(8);
    this.DYW.setVisibility(8);
    this.DYV.setVisibility(8);
    this.DZa.setVisibility(8);
    this.DYZ.setVisibility(8);
    if ((!Util.isNullOrNil(this.DZc)) && (!Util.isNullOrNil(this.DZb)))
    {
      bh.beI();
      paramBundle = com.tencent.mm.model.c.bbL().RG(this.DZc);
      if ((paramBundle != null) && (!com.tencent.mm.contact.d.rk(paramBundle.field_type)))
      {
        this.DZa.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26003);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            com.tencent.mm.plugin.report.service.h.IzE.a(12766, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new com.tencent.mm.pluginsdk.ui.applet.a(IPCallUserProfileUI.this, new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(26001);
                Log.d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
                if (paramAnonymous2Boolean1)
                {
                  IPCallUserProfileUI.a(IPCallUserProfileUI.this).setVisibility(8);
                  IPCallUserProfileUI.b(IPCallUserProfileUI.this).setVisibility(8);
                  IPCallUserProfileUI.b(IPCallUserProfileUI.this, paramAnonymous2String1);
                }
                AppMethodBeat.o(26001);
              }
            });
            localObject = new LinkedList();
            ((LinkedList)localObject).add(Integer.valueOf(86));
            paramAnonymousView.ReH = new a.b()
            {
              public final boolean m(String paramAnonymous2String1, int paramAnonymous2Int, String paramAnonymous2String2)
              {
                AppMethodBeat.i(284989);
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_User", IPCallUserProfileUI.c(IPCallUserProfileUI.this));
                localIntent.putExtra("Contact_Scene", 13);
                localIntent.putExtra(f.d.VRW, paramAnonymous2String1);
                paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWD, 2);
                int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWG, 5000);
                paramAnonymous2String2 = ".ui.SayHiWithSnsPermissionUI";
                if ((!as.bvK(IPCallUserProfileUI.c(IPCallUserProfileUI.this))) && (paramAnonymous2Int == 1)) {
                  paramAnonymous2String1 = ".ui.SayHiWithSnsPermissionUI2";
                }
                for (;;)
                {
                  com.tencent.mm.by.c.b(IPCallUserProfileUI.this, "profile", paramAnonymous2String1, localIntent);
                  AppMethodBeat.o(284989);
                  return true;
                  paramAnonymous2String1 = paramAnonymous2String2;
                  if (!as.bvK(IPCallUserProfileUI.c(IPCallUserProfileUI.this)))
                  {
                    paramAnonymous2String1 = paramAnonymous2String2;
                    if (paramAnonymous2Int == 2)
                    {
                      paramAnonymous2String1 = paramAnonymous2String2;
                      if (ab.bef() >= i) {
                        paramAnonymous2String1 = ".ui.SayHiWithSnsPermissionUI3";
                      }
                    }
                  }
                }
              }
            };
            paramAnonymousView.b(IPCallUserProfileUI.c(IPCallUserProfileUI.this), (LinkedList)localObject, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26003);
          }
        });
        this.DZa.setText(R.l.eIV);
        this.DZa.setVisibility(0);
      }
    }
    for (;;)
    {
      eKr();
      AppMethodBeat.o(26008);
      return;
      label747:
      bool = false;
      break;
      if ((!Util.isNullOrNil(this.fXl)) && (!Util.isNullOrNil(this.DZb)))
      {
        eKs();
        this.DZa.setText(R.l.eIW);
      }
      else if (!Util.isNullOrNil(this.fVa))
      {
        this.DYW.setVisibility(0);
        this.DYX.setVisibility(0);
        paramBundle = MMApplicationContext.getContext();
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", "10086");
        if (Util.isIntentAvailable(paramBundle, localIntent)) {
          this.DYV.setVisibility(0);
        }
        this.DYV.setOnClickListener(new IPCallUserProfileUI.10(this));
        this.DYW.setOnClickListener(new IPCallUserProfileUI.11(this));
        this.DYX.setOnClickListener(new IPCallUserProfileUI.2(this));
        eKs();
        this.DZa.setText(R.l.eIW);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26016);
    super.onResume();
    if (this.DZe)
    {
      this.DZe = false;
      this.DYU.removeAllViews();
      eKt();
    }
    AppMethodBeat.o(26016);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI
 * JD-Core Version:    0.7.0.1
 */