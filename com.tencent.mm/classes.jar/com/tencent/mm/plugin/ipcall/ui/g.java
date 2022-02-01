package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.f.d;
import com.tencent.mm.plugin.ipcall.model.h.f;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.gdf;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.widget.a.i;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends i
{
  private int Akr;
  private int Aks;
  private int JMW;
  private int JMX;
  private long JMY;
  private LinearLayout JMZ;
  private LinearLayout JNa;
  private RelativeLayout JNb;
  private RelativeLayout JNc;
  private RelativeLayout JNd;
  private ImageView JNe;
  private ImageView JNf;
  private ImageView JNg;
  private int JNh;
  private FrameLayout JNi;
  private FlowLayout JNj;
  private Button JNk;
  private Button JNl;
  private PasterEditText JNm;
  private Button JNn;
  private Button JNo;
  private TextView JNp;
  private Animation JNq;
  private int JNr;
  private int JNs;
  private CharSequence cZ;
  private Activity mActivity;
  private Context mContext;
  private MMHandler mHandler;
  private View.OnClickListener mOnClickListener;
  private ScrollView pLK;
  View plc;
  private ArrayList<a> xHy;
  
  public g(final Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, R.m.mmalertdialog);
    AppMethodBeat.i(25778);
    this.JMW = 0;
    this.mHandler = new MMHandler();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (paramAnonymousView == g.b(g.this)) {
          g.a(g.this, 1);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25771);
          return;
          if (paramAnonymousView == g.c(g.this)) {
            g.a(g.this, 2);
          } else if (paramAnonymousView == g.d(g.this)) {
            g.a(g.this, 3);
          }
        }
      }
    };
    this.Aks = R.g.fnK;
    this.Akr = R.e.fkA;
    this.JNr = R.g.fnJ;
    this.JNs = R.e.white_text_color;
    setCancelable(false);
    this.mContext = paramContext;
    this.JMX = paramInt;
    this.JMY = paramLong;
    this.mActivity = paramActivity;
    this.plc = View.inflate(this.mContext, R.i.gkU, null);
    this.JMZ = ((LinearLayout)this.plc.findViewById(R.h.fMu));
    this.JNa = ((LinearLayout)this.plc.findViewById(R.h.fMv));
    this.JNq = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.a.alpha_in);
    this.JNq.setDuration(200L);
    this.JNq.setStartOffset(100L);
    this.JNi = ((FrameLayout)this.plc.findViewById(R.h.fIo));
    this.JNj = ((FlowLayout)this.plc.findViewById(R.h.fIn));
    this.JNk = ((Button)this.plc.findViewById(R.h.fBw));
    this.JNl = ((Button)this.plc.findViewById(R.h.fBx));
    this.JNm = ((PasterEditText)this.plc.findViewById(R.h.confirm_dialog_text_et));
    this.JNk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        g.this.dismiss();
        d.a(-1, 1, -1, "", 0, -1, -1, g.e(g.this), g.f(g.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25772);
      }
    });
    this.JNl.setOnClickListener(new g.5(this));
    Object localObject1 = com.tencent.mm.plugin.ipcall.model.e.fRi();
    if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).JFV == null)
    {
      Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      paramActivity = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(39, 1);
      if (Util.isNullOrNil(paramActivity)) {
        break label573;
      }
      paramActivity = y.bi(paramActivity, 0, -1);
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.ipcall.model.e)localObject1).bX(paramActivity);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).JFV == null) {
        break label616;
      }
      paramActivity = LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((!"language_default".equalsIgnoreCase(paramActivity)) || (Locale.getDefault() == null)) {
        break label1144;
      }
      paramActivity = Locale.getDefault().toString();
    }
    label474:
    label616:
    label1144:
    for (;;)
    {
      Object localObject2 = ((com.tencent.mm.plugin.ipcall.model.e)localObject1).JFV.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramContext = (f)((Iterator)localObject2).next();
        if (paramActivity.equalsIgnoreCase(paramContext.JJU))
        {
          Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).JFV.size()) });
          paramActivity = paramContext;
        }
      }
      for (;;)
      {
        if (paramActivity != null)
        {
          paramContext = paramActivity.JJV;
          paramActivity = new ArrayList();
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.ipcall.model.h.e)paramContext.next();
              localObject2 = new a();
              ((a)localObject2).Id = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).Id;
              ((a)localObject2).IHZ = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).IHZ;
              ((a)localObject2).JNu = false;
              paramActivity.add(localObject2);
              continue;
              Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).JFV.size()) });
              paramActivity = null;
              break label474;
            }
          }
          this.xHy = paramActivity;
          paramActivity = this.xHy.iterator();
          while (paramActivity.hasNext())
          {
            paramContext = (a)paramActivity.next();
            localObject1 = this.JNj;
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setTextSize(0, getContext().getResources().getDimension(R.f.flG) * com.tencent.mm.cd.a.getScaleSize(getContext()));
            ((TextView)localObject2).setBackgroundResource(this.Aks);
            ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(this.Akr));
            ((TextView)localObject2).setTag(paramContext);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setText(paramContext.IHZ);
            ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(25774);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                localObject = (g.a)paramAnonymousView.getTag();
                if (!((g.a)localObject).JNu) {}
                for (((g.a)localObject).JNu = true;; ((g.a)localObject).JNu = false)
                {
                  g.a(g.this, (TextView)paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(25774);
                  return;
                }
              }
            });
            ((FlowLayout)localObject1).addView((View)localObject2);
          }
        }
      }
      this.JNb = ((RelativeLayout)this.plc.findViewById(R.h.fMy));
      this.JNc = ((RelativeLayout)this.plc.findViewById(R.h.fMz));
      this.JNd = ((RelativeLayout)this.plc.findViewById(R.h.fMA));
      this.JNb.setOnClickListener(this.mOnClickListener);
      this.JNc.setOnClickListener(this.mOnClickListener);
      this.JNd.setOnClickListener(this.mOnClickListener);
      this.JNe = ((ImageView)this.plc.findViewById(R.h.fKv));
      this.JNf = ((ImageView)this.plc.findViewById(R.h.fKw));
      this.JNg = ((ImageView)this.plc.findViewById(R.h.fKx));
      this.JNh = 0;
      Zm(this.JNh);
      this.JNn = ((Button)this.plc.findViewById(R.h.fKE));
      this.JNo = ((Button)this.plc.findViewById(R.h.fKF));
      this.JNp = ((TextView)this.plc.findViewById(R.h.fKG));
      paramActivity = c.fSO();
      if (paramActivity != null) {}
      for (paramActivity = String.format(this.mContext.getString(R.l.gLL), new Object[] { paramActivity.aaBu });; paramActivity = null)
      {
        if (Util.isNullOrNil(paramActivity)) {
          this.JNp.setVisibility(4);
        }
        for (;;)
        {
          this.JNn.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25775);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              g.this.dismiss();
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, -1, 1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25775);
            }
          });
          this.JNo.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25776);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              g.this.dismiss();
              localObject = new Intent();
              ((Intent)localObject).putExtra("IPCallShareCouponCardUI_KFrom", 2);
              ((Intent)localObject).setClass(g.i(g.this), IPCallShareCouponCardUI.class);
              paramAnonymousView = g.i(g.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, 1, -1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25776);
            }
          });
          this.pLK = ((ScrollView)this.plc.findViewById(R.h.fHN));
          paramActivity = ((ViewGroup)this.mActivity.findViewById(16908290)).getChildAt(0);
          paramActivity.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              AppMethodBeat.i(25769);
              Object localObject = new Rect();
              paramActivity.getWindowVisibleDisplayFrame((Rect)localObject);
              if (paramActivity.getRootView().getHeight() - (((Rect)localObject).bottom - ((Rect)localObject).top) > 100)
              {
                localObject = g.this;
                ((g)localObject).plc.postDelayed(new g.2((g)localObject), 100L);
              }
              AppMethodBeat.o(25769);
            }
          });
          AppMethodBeat.o(25778);
          return;
          this.JNp.setVisibility(0);
          this.JNp.setText(paramActivity);
        }
      }
    }
  }
  
  private void Zm(int paramInt)
  {
    AppMethodBeat.i(25780);
    this.JNh = paramInt;
    if (paramInt == 0)
    {
      this.JNe.setVisibility(4);
      this.JNf.setVisibility(4);
      this.JNg.setVisibility(4);
      this.JNl.setEnabled(false);
      Zp(0);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 1)
    {
      this.JNe.setVisibility(0);
      this.JNf.setVisibility(4);
      this.JNg.setVisibility(4);
      this.JNl.setEnabled(true);
      Zp(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 2)
    {
      this.JNe.setVisibility(0);
      this.JNf.setVisibility(0);
      this.JNg.setVisibility(4);
      this.JNl.setEnabled(true);
      Zp(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 3)
    {
      this.JNe.setVisibility(0);
      this.JNf.setVisibility(0);
      this.JNg.setVisibility(0);
      this.JNl.setEnabled(true);
      Zp(0);
    }
    AppMethodBeat.o(25780);
  }
  
  private String Zn(int paramInt)
  {
    AppMethodBeat.i(25781);
    String str = "";
    if (paramInt == 3)
    {
      AppMethodBeat.o(25781);
      return "";
    }
    if (!Util.isNullOrNil(this.JNm.getText().toString().trim())) {
      str = "0";
    }
    Object localObject;
    if (this.xHy != null)
    {
      Iterator localIterator = this.xHy.iterator();
      for (;;)
      {
        localObject = str;
        if (!localIterator.hasNext()) {
          break label145;
        }
        localObject = (a)localIterator.next();
        if (!((a)localObject).JNu) {
          break label153;
        }
        if (!str.equals("")) {
          break;
        }
        str = ((a)localObject).Id;
      }
      str = str + "_" + ((a)localObject).Id;
    }
    label145:
    label153:
    for (;;)
    {
      break;
      localObject = str;
      AppMethodBeat.o(25781);
      return localObject;
    }
  }
  
  private LinkedList<gdf> Zo(int paramInt)
  {
    AppMethodBeat.i(25782);
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3)
    {
      AppMethodBeat.o(25782);
      return localLinkedList;
    }
    Object localObject1 = this.JNm.getText().toString().trim();
    Object localObject2;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject2 = new gdf();
      ((gdf)localObject2).hjP = 0;
      ((gdf)localObject2).nUB = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.xHy != null)
    {
      localObject1 = this.xHy.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (((a)localObject2).JNu)
        {
          gdf localgdf = new gdf();
          try
          {
            localgdf.hjP = Util.getInt(((a)localObject2).Id, 0);
            localLinkedList.add(localgdf);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Log.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + ((a)localObject2).Id);
          }
        }
      }
    }
    AppMethodBeat.o(25782);
    return localLinkedList;
  }
  
  private void Zp(int paramInt)
  {
    AppMethodBeat.i(25785);
    if (paramInt == 0)
    {
      this.JMZ.setVisibility(0);
      this.JNa.setVisibility(4);
      if (this.JMW == 1)
      {
        ((LinearLayout.LayoutParams)this.JNi.getLayoutParams()).height = 0;
        this.JNi.requestLayout();
      }
      Util.hideVKB(this.plc);
    }
    for (;;)
    {
      this.JMW = paramInt;
      AppMethodBeat.o(25785);
      return;
      if (paramInt == 1)
      {
        this.JMZ.setVisibility(0);
        this.JNa.setVisibility(4);
        if (this.JMW == 0)
        {
          ((LinearLayout.LayoutParams)this.JNi.getLayoutParams()).height = -2;
          this.JNi.requestLayout();
          this.JNi.startAnimation(this.JNq);
        }
      }
      else if (paramInt == 2)
      {
        this.JMZ.setVisibility(4);
        this.JNa.setVisibility(0);
        Util.hideVKB(this.plc);
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(25784);
    try
    {
      super.dismiss();
      AppMethodBeat.o(25784);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(25784);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25779);
    super.onCreate(paramBundle);
    setContentView(this.plc);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    Zp(0);
    AppMethodBeat.o(25779);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.cZ = paramCharSequence;
      return;
    }
    this.cZ = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(25783);
    super.show();
    AppMethodBeat.o(25783);
  }
  
  public static final class a
  {
    public String IHZ;
    public String Id;
    public boolean JNu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */