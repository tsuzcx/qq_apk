package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.fgt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends i
{
  private int DVN;
  private int DVO;
  private long DVP;
  private LinearLayout DVQ;
  private LinearLayout DVR;
  private RelativeLayout DVS;
  private RelativeLayout DVT;
  private RelativeLayout DVU;
  private ImageView DVV;
  private ImageView DVW;
  private ImageView DVX;
  private int DVY;
  private FrameLayout DVZ;
  private FlowLayout DWa;
  private Button DWb;
  private Button DWc;
  private PasterEditText DWd;
  private Button DWe;
  private Button DWf;
  private TextView DWg;
  private Animation DWh;
  private int DWi;
  private int DWj;
  private CharSequence cZ;
  private Activity mActivity;
  private Context mContext;
  private MMHandler mHandler;
  private ArrayList<a> mItemList;
  private View.OnClickListener mOnClickListener;
  private ScrollView mPe;
  View mrI;
  private int wNO;
  private int wNP;
  
  public g(Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, R.m.mmalertdialog);
    AppMethodBeat.i(25778);
    this.DVN = 0;
    this.mHandler = new MMHandler();
    this.mOnClickListener = new g.3(this);
    this.wNP = R.g.dnw;
    this.wNO = R.e.dkv;
    this.DWi = R.g.dnv;
    this.DWj = R.e.white_text_color;
    setCancelable(false);
    this.mContext = paramContext;
    this.DVO = paramInt;
    this.DVP = paramLong;
    this.mActivity = paramActivity;
    this.mrI = View.inflate(this.mContext, R.i.ehZ, null);
    this.DVQ = ((LinearLayout)this.mrI.findViewById(R.h.dKS));
    this.DVR = ((LinearLayout)this.mrI.findViewById(R.h.dKT));
    this.DWh = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.a.alpha_in);
    this.DWh.setDuration(200L);
    this.DWh.setStartOffset(100L);
    this.DVZ = ((FrameLayout)this.mrI.findViewById(R.h.dHf));
    this.DWa = ((FlowLayout)this.mrI.findViewById(R.h.dHe));
    this.DWb = ((Button)this.mrI.findViewById(R.h.dAz));
    this.DWc = ((Button)this.mrI.findViewById(R.h.dAA));
    this.DWd = ((PasterEditText)this.mrI.findViewById(R.h.confirm_dialog_text_et));
    this.DWb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        g.this.dismiss();
        d.a(-1, 1, -1, "", 0, -1, -1, g.e(g.this), g.f(g.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25772);
      }
    });
    this.DWc.setOnClickListener(new g.5(this));
    Object localObject1 = com.tencent.mm.plugin.ipcall.model.e.eJi();
    if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).DOG == null)
    {
      Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      com.tencent.mm.pluginsdk.k.a.a.b.hii();
      paramActivity = com.tencent.mm.pluginsdk.k.a.a.b.lV(39, 1);
      if (Util.isNullOrNil(paramActivity)) {
        break label569;
      }
      paramActivity = u.aY(paramActivity, 0, -1);
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.ipcall.model.e)localObject1).bV(paramActivity);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).DOG == null) {
        break label610;
      }
      paramActivity = LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
      if ((!"language_default".equalsIgnoreCase(paramActivity)) || (Locale.getDefault() == null)) {
        break label1138;
      }
      paramActivity = Locale.getDefault().toString();
    }
    label471:
    label610:
    label1138:
    for (;;)
    {
      Object localObject2 = ((com.tencent.mm.plugin.ipcall.model.e)localObject1).DOG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramContext = (f)((Iterator)localObject2).next();
        if (paramActivity.equalsIgnoreCase(paramContext.DSK))
        {
          Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).DOG.size()) });
          paramActivity = paramContext;
        }
      }
      for (;;)
      {
        if (paramActivity != null)
        {
          paramContext = paramActivity.DSL;
          paramActivity = new ArrayList();
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.ipcall.model.h.e)paramContext.next();
              localObject2 = new a();
              ((a)localObject2).Id = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).Id;
              ((a)localObject2).CNP = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).CNP;
              ((a)localObject2).DWl = false;
              paramActivity.add(localObject2);
              continue;
              Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).DOG.size()) });
              paramActivity = null;
              break label471;
            }
          }
          this.mItemList = paramActivity;
          paramActivity = this.mItemList.iterator();
          while (paramActivity.hasNext())
          {
            paramContext = (a)paramActivity.next();
            localObject1 = this.DWa;
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setTextSize(0, getContext().getResources().getDimension(R.f.dlq) * com.tencent.mm.ci.a.ez(getContext()));
            ((TextView)localObject2).setBackgroundResource(this.wNP);
            ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(this.wNO));
            ((TextView)localObject2).setTag(paramContext);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setText(paramContext.CNP);
            ((TextView)localObject2).setOnClickListener(new g.6(this));
            ((FlowLayout)localObject1).addView((View)localObject2);
          }
        }
      }
      this.DVS = ((RelativeLayout)this.mrI.findViewById(R.h.dKW));
      this.DVT = ((RelativeLayout)this.mrI.findViewById(R.h.dKX));
      this.DVU = ((RelativeLayout)this.mrI.findViewById(R.h.dKY));
      this.DVS.setOnClickListener(this.mOnClickListener);
      this.DVT.setOnClickListener(this.mOnClickListener);
      this.DVU.setOnClickListener(this.mOnClickListener);
      this.DVV = ((ImageView)this.mrI.findViewById(R.h.dJa));
      this.DVW = ((ImageView)this.mrI.findViewById(R.h.dJb));
      this.DVX = ((ImageView)this.mrI.findViewById(R.h.dJc));
      this.DVY = 0;
      Vr(this.DVY);
      this.DWe = ((Button)this.mrI.findViewById(R.h.dJk));
      this.DWf = ((Button)this.mrI.findViewById(R.h.dJl));
      this.DWg = ((TextView)this.mrI.findViewById(R.h.dJm));
      paramActivity = c.eKP();
      if (paramActivity != null) {}
      for (paramActivity = String.format(this.mContext.getString(R.l.eKe), new Object[] { paramActivity.Tno });; paramActivity = null)
      {
        if (Util.isNullOrNil(paramActivity)) {
          this.DWg.setVisibility(4);
        }
        for (;;)
        {
          this.DWe.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25775);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              g.this.dismiss();
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, -1, 1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25775);
            }
          });
          this.DWf.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25776);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              g.this.dismiss();
              localObject = new Intent();
              ((Intent)localObject).putExtra("IPCallShareCouponCardUI_KFrom", 2);
              ((Intent)localObject).setClass(g.i(g.this), IPCallShareCouponCardUI.class);
              paramAnonymousView = g.i(g.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, 1, -1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25776);
            }
          });
          this.mPe = ((ScrollView)this.mrI.findViewById(R.h.dGG));
          paramActivity = ((ViewGroup)this.mActivity.findViewById(16908290)).getChildAt(0);
          paramActivity.getViewTreeObserver().addOnGlobalLayoutListener(new g.1(this, paramActivity));
          AppMethodBeat.o(25778);
          return;
          this.DWg.setVisibility(0);
          this.DWg.setText(paramActivity);
        }
      }
    }
  }
  
  private void Vr(int paramInt)
  {
    AppMethodBeat.i(25780);
    this.DVY = paramInt;
    if (paramInt == 0)
    {
      this.DVV.setVisibility(4);
      this.DVW.setVisibility(4);
      this.DVX.setVisibility(4);
      this.DWc.setEnabled(false);
      Vu(0);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 1)
    {
      this.DVV.setVisibility(0);
      this.DVW.setVisibility(4);
      this.DVX.setVisibility(4);
      this.DWc.setEnabled(true);
      Vu(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 2)
    {
      this.DVV.setVisibility(0);
      this.DVW.setVisibility(0);
      this.DVX.setVisibility(4);
      this.DWc.setEnabled(true);
      Vu(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 3)
    {
      this.DVV.setVisibility(0);
      this.DVW.setVisibility(0);
      this.DVX.setVisibility(0);
      this.DWc.setEnabled(true);
      Vu(0);
    }
    AppMethodBeat.o(25780);
  }
  
  private String Vs(int paramInt)
  {
    AppMethodBeat.i(25781);
    String str = "";
    if (paramInt == 3)
    {
      AppMethodBeat.o(25781);
      return "";
    }
    if (!Util.isNullOrNil(this.DWd.getText().toString().trim())) {
      str = "0";
    }
    Object localObject;
    if (this.mItemList != null)
    {
      Iterator localIterator = this.mItemList.iterator();
      for (;;)
      {
        localObject = str;
        if (!localIterator.hasNext()) {
          break label145;
        }
        localObject = (a)localIterator.next();
        if (!((a)localObject).DWl) {
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
  
  private LinkedList<fgt> Vt(int paramInt)
  {
    AppMethodBeat.i(25782);
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3)
    {
      AppMethodBeat.o(25782);
      return localLinkedList;
    }
    Object localObject1 = this.DWd.getText().toString().trim();
    Object localObject2;
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject2 = new fgt();
      ((fgt)localObject2).ffF = 0;
      ((fgt)localObject2).lpy = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.mItemList != null)
    {
      localObject1 = this.mItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (((a)localObject2).DWl)
        {
          fgt localfgt = new fgt();
          try
          {
            localfgt.ffF = Util.getInt(((a)localObject2).Id, 0);
            localLinkedList.add(localfgt);
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
  
  private void Vu(int paramInt)
  {
    AppMethodBeat.i(25785);
    if (paramInt == 0)
    {
      this.DVQ.setVisibility(0);
      this.DVR.setVisibility(4);
      if (this.DVN == 1)
      {
        ((LinearLayout.LayoutParams)this.DVZ.getLayoutParams()).height = 0;
        this.DVZ.requestLayout();
      }
      Util.hideVKB(this.mrI);
    }
    for (;;)
    {
      this.DVN = paramInt;
      AppMethodBeat.o(25785);
      return;
      if (paramInt == 1)
      {
        this.DVQ.setVisibility(0);
        this.DVR.setVisibility(4);
        if (this.DVN == 0)
        {
          ((LinearLayout.LayoutParams)this.DVZ.getLayoutParams()).height = -2;
          this.DVZ.requestLayout();
          this.DVZ.startAnimation(this.DWh);
        }
      }
      else if (paramInt == 2)
      {
        this.DVQ.setVisibility(4);
        this.DVR.setVisibility(0);
        Util.hideVKB(this.mrI);
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
    setContentView(this.mrI);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    Vu(0);
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
    public String CNP;
    public boolean DWl;
    public String Id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */