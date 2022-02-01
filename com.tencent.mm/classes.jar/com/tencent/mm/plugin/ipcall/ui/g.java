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
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.f.d;
import com.tencent.mm.plugin.ipcall.model.h.f;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends com.tencent.mm.ui.base.i
{
  private CharSequence Hd;
  View iCR;
  private ScrollView kLj;
  private Activity mActivity;
  private Context mContext;
  private ap mHandler;
  private ArrayList<a> mItemList;
  private View.OnClickListener mOnClickListener;
  private int rzF;
  private int rzG;
  private LinearLayout uRA;
  private LinearLayout uRB;
  private RelativeLayout uRC;
  private RelativeLayout uRD;
  private RelativeLayout uRE;
  private ImageView uRF;
  private ImageView uRG;
  private ImageView uRH;
  private int uRI;
  private FrameLayout uRJ;
  private FlowLayout uRK;
  private Button uRL;
  private Button uRM;
  private PasterEditText uRN;
  private Button uRO;
  private Button uRP;
  private TextView uRQ;
  private Animation uRR;
  private int uRS;
  private int uRT;
  private int uRx;
  private int uRy;
  private long uRz;
  
  public g(final Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(25778);
    this.uRx = 0;
    this.mHandler = new ap();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.rzG = 2131232305;
    this.rzF = 2131100367;
    this.uRS = 2131232302;
    this.uRT = 2131101182;
    setCancelable(false);
    this.mContext = paramContext;
    this.uRy = paramInt;
    this.uRz = paramLong;
    this.mActivity = paramActivity;
    this.iCR = View.inflate(this.mContext, 2131494514, null);
    this.uRA = ((LinearLayout)this.iCR.findViewById(2131301346));
    this.uRB = ((LinearLayout)this.iCR.findViewById(2131301347));
    this.uRR = AnimationUtils.loadAnimation(aj.getContext(), 2130771981);
    this.uRR.setDuration(200L);
    this.uRR.setStartOffset(100L);
    this.uRJ = ((FrameLayout)this.iCR.findViewById(2131300141));
    this.uRK = ((FlowLayout)this.iCR.findViewById(2131300140));
    this.uRL = ((Button)this.iCR.findViewById(2131298559));
    this.uRM = ((Button)this.iCR.findViewById(2131298560));
    this.uRN = ((PasterEditText)this.iCR.findViewById(2131298569));
    this.uRL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.this.dismiss();
        d.a(-1, 1, -1, "", 0, -1, -1, g.e(g.this), g.f(g.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25772);
      }
    });
    this.uRM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25773);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.g(g.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25773);
      }
    });
    Object localObject1 = com.tencent.mm.plugin.ipcall.model.e.ddy();
    if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).uKq == null)
    {
      ad.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      com.tencent.mm.pluginsdk.j.a.a.b.faE();
      paramActivity = com.tencent.mm.pluginsdk.j.a.a.b.jm(39, 1);
      if (bt.isNullOrNil(paramActivity)) {
        break label558;
      }
      paramActivity = com.tencent.mm.vfs.i.aY(paramActivity, 0, -1);
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.ipcall.model.e)localObject1).bq(paramActivity);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).uKq == null) {
        break label599;
      }
      paramActivity = aj.getContext().getSharedPreferences(aj.fkC(), 0);
      aj.getContext();
      paramActivity = ac.g(paramActivity);
      if ((!"language_default".equalsIgnoreCase(paramActivity)) || (Locale.getDefault() == null)) {
        break label1127;
      }
      paramActivity = Locale.getDefault().toString();
    }
    label460:
    label599:
    label1127:
    for (;;)
    {
      Object localObject2 = ((com.tencent.mm.plugin.ipcall.model.e)localObject1).uKq.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramContext = (f)((Iterator)localObject2).next();
        if (paramActivity.equalsIgnoreCase(paramContext.uOu))
        {
          ad.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).uKq.size()) });
          paramActivity = paramContext;
        }
      }
      for (;;)
      {
        if (paramActivity != null)
        {
          paramContext = paramActivity.uOv;
          paramActivity = new ArrayList();
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.ipcall.model.h.e)paramContext.next();
              localObject2 = new a();
              ((a)localObject2).Id = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).Id;
              ((a)localObject2).uOt = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).uOt;
              ((a)localObject2).uRV = false;
              paramActivity.add(localObject2);
              continue;
              ad.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              ad.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              ad.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).uKq.size()) });
              paramActivity = null;
              break label460;
            }
          }
          this.mItemList = paramActivity;
          paramActivity = this.mItemList.iterator();
          while (paramActivity.hasNext())
          {
            paramContext = (a)paramActivity.next();
            localObject1 = this.uRK;
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setTextSize(0, getContext().getResources().getDimension(2131166295) * com.tencent.mm.cc.a.eb(getContext()));
            ((TextView)localObject2).setBackgroundResource(this.rzG);
            ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(this.rzF));
            ((TextView)localObject2).setTag(paramContext);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setText(paramContext.uOt);
            ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(25774);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                localObject = (g.a)paramAnonymousView.getTag();
                if (!((g.a)localObject).uRV) {}
                for (((g.a)localObject).uRV = true;; ((g.a)localObject).uRV = false)
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
      this.uRC = ((RelativeLayout)this.iCR.findViewById(2131301351));
      this.uRD = ((RelativeLayout)this.iCR.findViewById(2131301352));
      this.uRE = ((RelativeLayout)this.iCR.findViewById(2131301353));
      this.uRC.setOnClickListener(this.mOnClickListener);
      this.uRD.setOnClickListener(this.mOnClickListener);
      this.uRE.setOnClickListener(this.mOnClickListener);
      this.uRF = ((ImageView)this.iCR.findViewById(2131300980));
      this.uRG = ((ImageView)this.iCR.findViewById(2131300981));
      this.uRH = ((ImageView)this.iCR.findViewById(2131300982));
      this.uRI = 0;
      IH(this.uRI);
      this.uRO = ((Button)this.iCR.findViewById(2131301049));
      this.uRP = ((Button)this.iCR.findViewById(2131301050));
      this.uRQ = ((TextView)this.iCR.findViewById(2131301052));
      paramActivity = c.dfi();
      if (paramActivity != null) {}
      for (paramActivity = String.format(this.mContext.getString(2131760552), new Object[] { paramActivity.GFt });; paramActivity = null)
      {
        if (bt.isNullOrNil(paramActivity)) {
          this.uRQ.setVisibility(4);
        }
        for (;;)
        {
          this.uRO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25775);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              g.this.dismiss();
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, -1, 1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25775);
            }
          });
          this.uRP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25776);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              g.this.dismiss();
              localObject = new Intent();
              ((Intent)localObject).putExtra("IPCallShareCouponCardUI_KFrom", 2);
              ((Intent)localObject).setClass(g.i(g.this), IPCallShareCouponCardUI.class);
              paramAnonymousView = g.i(g.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, 1, -1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25776);
            }
          });
          this.kLj = ((ScrollView)this.iCR.findViewById(2131299891));
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
                ((g)localObject).iCR.postDelayed(new g.2((g)localObject), 100L);
              }
              AppMethodBeat.o(25769);
            }
          });
          AppMethodBeat.o(25778);
          return;
          this.uRQ.setVisibility(0);
          this.uRQ.setText(paramActivity);
        }
      }
    }
  }
  
  private void IH(int paramInt)
  {
    AppMethodBeat.i(25780);
    this.uRI = paramInt;
    if (paramInt == 0)
    {
      this.uRF.setVisibility(4);
      this.uRG.setVisibility(4);
      this.uRH.setVisibility(4);
      this.uRM.setEnabled(false);
      IK(0);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 1)
    {
      this.uRF.setVisibility(0);
      this.uRG.setVisibility(4);
      this.uRH.setVisibility(4);
      this.uRM.setEnabled(true);
      IK(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 2)
    {
      this.uRF.setVisibility(0);
      this.uRG.setVisibility(0);
      this.uRH.setVisibility(4);
      this.uRM.setEnabled(true);
      IK(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 3)
    {
      this.uRF.setVisibility(0);
      this.uRG.setVisibility(0);
      this.uRH.setVisibility(0);
      this.uRM.setEnabled(true);
      IK(0);
    }
    AppMethodBeat.o(25780);
  }
  
  private String II(int paramInt)
  {
    AppMethodBeat.i(25781);
    String str = "";
    if (paramInt == 3)
    {
      AppMethodBeat.o(25781);
      return "";
    }
    if (!bt.isNullOrNil(this.uRN.getText().toString().trim())) {
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
        if (!((a)localObject).uRV) {
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
  
  private LinkedList<eaj> IJ(int paramInt)
  {
    AppMethodBeat.i(25782);
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3)
    {
      AppMethodBeat.o(25782);
      return localLinkedList;
    }
    Object localObject1 = this.uRN.getText().toString().trim();
    Object localObject2;
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = new eaj();
      ((eaj)localObject2).ID = 0;
      ((eaj)localObject2).hDa = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.mItemList != null)
    {
      localObject1 = this.mItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (((a)localObject2).uRV)
        {
          eaj localeaj = new eaj();
          try
          {
            localeaj.ID = bt.getInt(((a)localObject2).Id, 0);
            localLinkedList.add(localeaj);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ad.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + ((a)localObject2).Id);
          }
        }
      }
    }
    AppMethodBeat.o(25782);
    return localLinkedList;
  }
  
  private void IK(int paramInt)
  {
    AppMethodBeat.i(25785);
    if (paramInt == 0)
    {
      this.uRA.setVisibility(0);
      this.uRB.setVisibility(4);
      if (this.uRx == 1)
      {
        ((LinearLayout.LayoutParams)this.uRJ.getLayoutParams()).height = 0;
        this.uRJ.requestLayout();
      }
      bt.hideVKB(this.iCR);
    }
    for (;;)
    {
      this.uRx = paramInt;
      AppMethodBeat.o(25785);
      return;
      if (paramInt == 1)
      {
        this.uRA.setVisibility(0);
        this.uRB.setVisibility(4);
        if (this.uRx == 0)
        {
          ((LinearLayout.LayoutParams)this.uRJ.getLayoutParams()).height = -2;
          this.uRJ.requestLayout();
          this.uRJ.startAnimation(this.uRR);
        }
      }
      else if (paramInt == 2)
      {
        this.uRA.setVisibility(4);
        this.uRB.setVisibility(0);
        bt.hideVKB(this.iCR);
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
      ad.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(25784);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25779);
    super.onCreate(paramBundle);
    setContentView(this.iCR);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    IK(0);
    AppMethodBeat.o(25779);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Hd = paramCharSequence;
      return;
    }
    this.Hd = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(25783);
    super.show();
    AppMethodBeat.o(25783);
  }
  
  public static final class a
  {
    public String Id;
    public String uOt;
    public boolean uRV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */