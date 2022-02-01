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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import java.util.LinkedList;

public class IPCallUserProfileUI
  extends MMActivity
{
  private String dwc;
  private String dxO;
  private ImageView fxQ;
  private boolean tNx;
  private TextView tSa;
  private TextView tSb;
  private LinearLayout tSc;
  private LinearLayout tSd;
  private TextView tSe;
  private TextView tSf;
  private TextView tSg;
  private TextView tSh;
  private TextView tSi;
  private Button tSj;
  private String tSk;
  private String tSl;
  private Bitmap tSm;
  private boolean tSn;
  private Cursor tSo;
  private boolean tSp;
  private e tSq;
  
  public IPCallUserProfileUI()
  {
    AppMethodBeat.i(26007);
    this.tNx = false;
    this.tSo = null;
    this.tSp = false;
    this.tSq = new e();
    AppMethodBeat.o(26007);
  }
  
  private void a(com.tencent.mm.plugin.ipcall.model.h.k paramk, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26014);
    View localView = LayoutInflater.from(this).inflate(2131495145, this.tSd, false);
    TextView localTextView1 = (TextView)localView.findViewById(2131303486);
    TextView localTextView2 = (TextView)localView.findViewById(2131303488);
    TextView localTextView3 = (TextView)localView.findViewById(2131303489);
    localTextView2.setText(com.tencent.mm.plugin.ipcall.a.a.ajs(paramk.field_phonenumber));
    if (paramk.field_duration > 0L) {
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.vL(paramk.field_duration));
    }
    for (;;)
    {
      localTextView1.setText(com.tencent.mm.plugin.ipcall.a.c.vH(paramk.field_calltime));
      if (paramBoolean)
      {
        localView.setBackgroundDrawable(getResources().getDrawable(2131233672));
        int i = getResources().getDimensionPixelSize(2131166702);
        localView.setPadding(i, 0, i, 0);
      }
      if (1 == paramInt)
      {
        paramk = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramk.height = com.tencent.mm.cc.a.au(getContext(), 2131166673);
        localView.setLayoutParams(paramk);
      }
      this.tSd.addView(localView);
      AppMethodBeat.o(26014);
      return;
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.Hu(paramk.field_status));
    }
  }
  
  /* Error */
  private static String ajg(String paramString)
  {
    // Byte code:
    //   0: sipush 26011
    //   3: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 300	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   9: ldc_w 302
    //   12: invokestatic 307	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   15: ifne +20 -> 35
    //   18: ldc_w 309
    //   21: ldc_w 311
    //   24: invokestatic 317	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: sipush 26011
    //   30: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: areturn
    //   35: invokestatic 300	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   38: invokevirtual 323	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: getstatic 329	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   44: aconst_null
    //   45: ldc_w 331
    //   48: iconst_1
    //   49: anewarray 333	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: aastore
    //   56: aconst_null
    //   57: invokevirtual 339	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnonnull +11 -> 75
    //   67: sipush 26011
    //   70: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload 4
    //   77: invokeinterface 345 1 0
    //   82: istore_1
    //   83: iload_1
    //   84: ifeq +152 -> 236
    //   87: ldc_w 347
    //   90: astore_0
    //   91: aload_0
    //   92: astore_2
    //   93: aload_0
    //   94: astore_3
    //   95: aload 4
    //   97: invokeinterface 350 1 0
    //   102: ifne +138 -> 240
    //   105: aload_0
    //   106: astore_2
    //   107: aload 4
    //   109: aload 4
    //   111: ldc_w 352
    //   114: invokeinterface 356 2 0
    //   119: invokeinterface 359 2 0
    //   124: astore_3
    //   125: aload_0
    //   126: astore_2
    //   127: new 361	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 362	java/lang/StringBuilder:<init>	()V
    //   134: aload_0
    //   135: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 368
    //   145: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_0
    //   152: aload_0
    //   153: astore_2
    //   154: aload 4
    //   156: invokeinterface 375 1 0
    //   161: pop
    //   162: goto -71 -> 91
    //   165: astore_0
    //   166: ldc_w 309
    //   169: ldc_w 377
    //   172: iconst_2
    //   173: anewarray 256	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokevirtual 380	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload_0
    //   186: invokevirtual 384	java/lang/Object:getClass	()Ljava/lang/Class;
    //   189: invokevirtual 389	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 392	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 4
    //   198: invokeinterface 395 1 0
    //   203: aload_2
    //   204: astore_0
    //   205: aload_2
    //   206: ldc_w 368
    //   209: invokevirtual 398	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   212: iflt +16 -> 228
    //   215: aload_2
    //   216: iconst_0
    //   217: aload_2
    //   218: ldc_w 368
    //   221: invokevirtual 398	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   224: invokevirtual 402	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore_0
    //   228: sipush 26011
    //   231: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: areturn
    //   236: ldc_w 347
    //   239: astore_3
    //   240: aload 4
    //   242: invokeinterface 395 1 0
    //   247: aload_3
    //   248: astore_2
    //   249: goto -46 -> 203
    //   252: astore_0
    //   253: aload 4
    //   255: invokeinterface 395 1 0
    //   260: sipush 26011
    //   263: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: ldc_w 347
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
  
  private void cVA()
  {
    AppMethodBeat.i(26013);
    if (!this.tSp)
    {
      this.tSd.setVisibility(8);
      this.tSh.setVisibility(8);
    }
    Cursor localCursor;
    if (!bs.isNullOrNil(this.dxO))
    {
      localCursor = m.aiS(this.dxO);
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
            com.tencent.mm.plugin.ipcall.model.h.k localk = new com.tencent.mm.plugin.ipcall.model.h.k();
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
        ac.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", new Object[] { localException.getMessage() });
        return;
        localCursor = i.cUC().aiQ(this.dwc);
        break;
        if (j <= 0)
        {
          this.tSd.setVisibility(8);
          return;
        }
        if (localCursor.getCount() < 4) {
          continue;
        }
        cVB();
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(26013);
      }
      label262:
      this.tSd.setVisibility(8);
      this.tSh.setVisibility(8);
      AppMethodBeat.o(26013);
      return;
      label287:
      boolean bool = false;
    }
  }
  
  private void cVB()
  {
    AppMethodBeat.i(26015);
    View localView = LayoutInflater.from(this).inflate(2131495146, this.tSd, false);
    this.tSd.addView(localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25996);
        Object localObject = new Intent(IPCallUserProfileUI.this, IPCallAllRecordUI.class);
        if (!bs.isNullOrNil(IPCallUserProfileUI.e(IPCallUserProfileUI.this))) {
          ((Intent)localObject).putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.e(IPCallUserProfileUI.this));
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.g(IPCallUserProfileUI.this));
          paramAnonymousView = IPCallUserProfileUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(25996);
          return;
          if (!bs.isNullOrNil(IPCallUserProfileUI.f(IPCallUserProfileUI.this))) {
            ((Intent)localObject).putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.f(IPCallUserProfileUI.this));
          }
        }
      }
    });
    AppMethodBeat.o(26015);
  }
  
  private void cVy()
  {
    int i = 0;
    AppMethodBeat.i(26009);
    ArrayList localArrayList = new ArrayList();
    if ((this.tSo != null) && (this.tSo.getCount() > 0))
    {
      for (;;)
      {
        try
        {
          if ((!this.tSo.moveToFirst()) || (this.tSo.isAfterLast())) {
            break label224;
          }
          i += 1;
          str = this.tSo.getString(this.tSo.getColumnIndex("data1"));
          j = this.tSo.getInt(this.tSo.getColumnIndex("data2"));
          if (!localArrayList.contains(str))
          {
            localArrayList.add(str);
            if (i != this.tSo.getCount()) {
              continue;
            }
            o(str, j, false);
          }
        }
        catch (Exception localException)
        {
          String str;
          int j;
          ac.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[] { localException.getMessage() });
          return;
          o(str, j, true);
          continue;
        }
        finally
        {
          this.tSo.close();
          AppMethodBeat.o(26009);
        }
        this.tSo.moveToNext();
      }
      label224:
      this.tSo.close();
      AppMethodBeat.o(26009);
      return;
    }
    this.tSc.setVisibility(8);
    AppMethodBeat.o(26009);
  }
  
  private void cVz()
  {
    AppMethodBeat.i(26012);
    this.tSj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26004);
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).start();
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).tKX = 1L;
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).tKY = 5L;
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).finish();
        h.wUl.f(12766, new Object[] { Integer.valueOf(3) });
        Object localObject;
        if (!bs.isNullOrNil(IPCallUserProfileUI.e(IPCallUserProfileUI.this)))
        {
          localObject = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.ajh(IPCallUserProfileUI.e(IPCallUserProfileUI.this))));
          ((Intent)localObject).putExtra("sms_body", IPCallUserProfileUI.this.getString(2131760453, new Object[] { u.ayc().aaR() }));
          paramAnonymousView = IPCallUserProfileUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(26004);
          return;
        }
        if (!bs.isNullOrNil(IPCallUserProfileUI.f(IPCallUserProfileUI.this)))
        {
          localObject = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.f(IPCallUserProfileUI.this)));
          ((Intent)localObject).putExtra("sms_body", IPCallUserProfileUI.this.getString(2131760453, new Object[] { u.ayc().aaR() }));
          paramAnonymousView = IPCallUserProfileUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(26004);
      }
    });
    AppMethodBeat.o(26012);
  }
  
  private void o(final String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26010);
    View localView = LayoutInflater.from(this).inflate(2131495143, this.tSc, false);
    Object localObject = (LinearLayout)localView.findViewById(2131301448);
    if (!paramBoolean) {
      ((LinearLayout)localObject).setBackgroundDrawable(null);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(2131303239);
      final TextView localTextView = (TextView)localView.findViewById(2131303238);
      localTextView.setText(com.tencent.mm.plugin.ipcall.a.a.ajs(com.tencent.mm.plugin.ipcall.a.c.ajw(paramString)));
      ((TextView)localObject).setText(com.tencent.mm.plugin.ipcall.a.a.Ht(paramInt));
      localView.setClickable(true);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25997);
          IPCallUserProfileUI.a(IPCallUserProfileUI.this, paramString);
          AppMethodBeat.o(25997);
        }
      });
      localView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25998);
          IPCallUserProfileUI.a(IPCallUserProfileUI.this, localTextView);
          AppMethodBeat.o(25998);
          return true;
        }
      });
      this.tSc.addView(localView);
      AppMethodBeat.o(26010);
      return;
      ((LinearLayout)localObject).setBackgroundDrawable(getResources().getDrawable(2131232867));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494509;
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
    h.wUl.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25994);
        IPCallUserProfileUI.this.finish();
        AppMethodBeat.o(25994);
        return true;
      }
    });
    setMMTitle(2131760472);
    this.fxQ = ((ImageView)findViewById(2131297008));
    this.tSa = ((TextView)findViewById(2131305595));
    this.tSb = ((TextView)findViewById(2131306958));
    this.tSc = ((LinearLayout)findViewById(2131303484));
    this.tSe = ((TextView)findViewById(2131303482));
    this.tSg = ((TextView)findViewById(2131303481));
    this.tSf = ((TextView)findViewById(2131303480));
    this.tSd = ((LinearLayout)findViewById(2131303487));
    this.tSh = ((TextView)findViewById(2131303904));
    this.tSi = ((TextView)findViewById(2131301063));
    this.tSj = ((Button)findViewById(2131303464));
    this.dxO = getIntent().getStringExtra("IPCallProfileUI_contactid");
    this.tSk = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
    this.tSl = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
    this.dwc = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
    this.tSp = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
    if (!bs.isNullOrNil(this.dxO))
    {
      this.tSm = com.tencent.mm.plugin.ipcall.a.a.aL(this, this.dxO);
      if (this.tSm != null) {
        this.fxQ.setImageBitmap(this.tSm);
      }
    }
    if ((this.tSm == null) && (!bs.isNullOrNil(this.tSl)))
    {
      this.tSm = com.tencent.mm.aj.c.a(this.tSl, false, -1, null);
      if (this.tSm != null) {
        this.fxQ.setImageBitmap(this.tSm);
      }
    }
    if (!bs.isNullOrNil(this.tSk))
    {
      this.tSa.setText(this.tSk);
      if ((bs.isNullOrNil(this.tSl)) || (this.tSl.endsWith("@stranger"))) {
        break label541;
      }
      paramBundle = getString(2131760473, new Object[] { v.wk(this.tSl) });
      this.tSb.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramBundle));
    }
    label541:
    boolean bool;
    for (;;)
    {
      if (!bs.isNullOrNil(this.dxO))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
        {
          ac.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
          AppMethodBeat.o(26008);
          return;
          if (bs.isNullOrNil(this.dwc)) {
            break;
          }
          this.tSa.setText(com.tencent.mm.plugin.ipcall.a.a.ajs(this.dwc));
          break;
          this.tSb.setVisibility(8);
          continue;
        }
        this.tSo = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[] { this.dxO }, null);
        if (this.tSo.getCount() > 1) {
          break label747;
        }
        bool = true;
        this.tNx = bool;
      }
    }
    cVA();
    this.tSg.setVisibility(8);
    this.tSf.setVisibility(8);
    this.tSe.setVisibility(8);
    this.tSj.setVisibility(8);
    this.tSi.setVisibility(8);
    if ((!bs.isNullOrNil(this.tSl)) && (!bs.isNullOrNil(this.tSk)))
    {
      az.ayM();
      paramBundle = com.tencent.mm.model.c.awB().aNt(this.tSl);
      if ((paramBundle != null) && (!com.tencent.mm.n.b.ln(paramBundle.field_type)))
      {
        this.tSj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26003);
            h.wUl.f(12766, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new com.tencent.mm.pluginsdk.ui.applet.a(IPCallUserProfileUI.this, new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(26001);
                ac.d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
                if (paramAnonymous2Boolean1)
                {
                  IPCallUserProfileUI.a(IPCallUserProfileUI.this).setVisibility(8);
                  IPCallUserProfileUI.b(IPCallUserProfileUI.this).setVisibility(8);
                  IPCallUserProfileUI.b(IPCallUserProfileUI.this, paramAnonymous2String1);
                }
                AppMethodBeat.o(26001);
              }
            });
            LinkedList localLinkedList = new LinkedList();
            localLinkedList.add(Integer.valueOf(86));
            paramAnonymousView.DpJ = new a.b()
            {
              public final boolean ax(String paramAnonymous2String, int paramAnonymous2Int)
              {
                AppMethodBeat.i(26002);
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_User", IPCallUserProfileUI.c(IPCallUserProfileUI.this));
                localIntent.putExtra("Contact_Scene", 13);
                localIntent.putExtra(e.c.HgZ, paramAnonymous2String);
                paramAnonymous2Int = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbC, 0);
                paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI";
                if (paramAnonymous2Int == 1) {
                  paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI2";
                }
                for (;;)
                {
                  d.b(IPCallUserProfileUI.this, "profile", paramAnonymous2String, localIntent);
                  AppMethodBeat.o(26002);
                  return true;
                  if (paramAnonymous2Int == 2) {
                    paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI3";
                  }
                }
              }
            };
            paramAnonymousView.b(IPCallUserProfileUI.c(IPCallUserProfileUI.this), localLinkedList, true);
            AppMethodBeat.o(26003);
          }
        });
        this.tSj.setText(2131760465);
        this.tSj.setVisibility(0);
      }
    }
    for (;;)
    {
      cVy();
      AppMethodBeat.o(26008);
      return;
      label747:
      bool = false;
      break;
      if ((!bs.isNullOrNil(this.dxO)) && (!bs.isNullOrNil(this.tSk)))
      {
        cVz();
        this.tSj.setText(2131760470);
      }
      else if (!bs.isNullOrNil(this.dwc))
      {
        this.tSf.setVisibility(0);
        this.tSg.setVisibility(0);
        paramBundle = com.tencent.mm.sdk.platformtools.ai.getContext();
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", "10086");
        if (bs.ah(paramBundle, localIntent)) {
          this.tSe.setVisibility(0);
        }
        this.tSe.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26005);
            try
            {
              h.wUl.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
              Object localObject = new Intent("android.intent.action.INSERT");
              ((Intent)localObject).setType("vnd.android.cursor.dir/contact");
              ((Intent)localObject).putExtra("phone", IPCallUserProfileUI.f(IPCallUserProfileUI.this));
              paramAnonymousView = IPCallUserProfileUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(26005);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              ac.e("MicroMsg.IPCallUserProfileUI", paramAnonymousView.getMessage());
              AppMethodBeat.o(26005);
            }
          }
        });
        this.tSf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26006);
            IPCallUserProfileUI.a(IPCallUserProfileUI.this, IPCallUserProfileUI.f(IPCallUserProfileUI.this));
            AppMethodBeat.o(26006);
          }
        });
        this.tSg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(25995);
            h.wUl.f(12766, new Object[] { Integer.valueOf(4) });
            com.tencent.mm.plugin.ipcall.a.c.ajx(IPCallUserProfileUI.f(IPCallUserProfileUI.this));
            Toast.makeText(IPCallUserProfileUI.this, 2131760464, 0).show();
            AppMethodBeat.o(25995);
          }
        });
        cVz();
        this.tSj.setText(2131760470);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26016);
    super.onResume();
    if (this.tSn)
    {
      this.tSn = false;
      this.tSd.removeAllViews();
      cVA();
    }
    AppMethodBeat.o(26016);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI
 * JD-Core Version:    0.7.0.1
 */