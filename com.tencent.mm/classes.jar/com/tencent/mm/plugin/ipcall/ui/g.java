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
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.eca;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends i
{
  private CharSequence Hd;
  View iFK;
  private ScrollView kOy;
  private Activity mActivity;
  private Context mContext;
  private aq mHandler;
  private ArrayList<a> mItemList;
  private View.OnClickListener mOnClickListener;
  private int rHQ;
  private int rHR;
  private Button vdA;
  private Button vdB;
  private TextView vdC;
  private Animation vdD;
  private int vdE;
  private int vdF;
  private int vdj;
  private int vdk;
  private long vdl;
  private LinearLayout vdm;
  private LinearLayout vdn;
  private RelativeLayout vdo;
  private RelativeLayout vdp;
  private RelativeLayout vdq;
  private ImageView vdr;
  private ImageView vds;
  private ImageView vdt;
  private int vdu;
  private FrameLayout vdv;
  private FlowLayout vdw;
  private Button vdx;
  private Button vdy;
  private PasterEditText vdz;
  
  public g(final Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(25778);
    this.vdj = 0;
    this.mHandler = new aq();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.rHR = 2131232305;
    this.rHQ = 2131100367;
    this.vdE = 2131232302;
    this.vdF = 2131101182;
    setCancelable(false);
    this.mContext = paramContext;
    this.vdk = paramInt;
    this.vdl = paramLong;
    this.mActivity = paramActivity;
    this.iFK = View.inflate(this.mContext, 2131494514, null);
    this.vdm = ((LinearLayout)this.iFK.findViewById(2131301346));
    this.vdn = ((LinearLayout)this.iFK.findViewById(2131301347));
    this.vdD = AnimationUtils.loadAnimation(ak.getContext(), 2130771981);
    this.vdD.setDuration(200L);
    this.vdD.setStartOffset(100L);
    this.vdv = ((FrameLayout)this.iFK.findViewById(2131300141));
    this.vdw = ((FlowLayout)this.iFK.findViewById(2131300140));
    this.vdx = ((Button)this.iFK.findViewById(2131298559));
    this.vdy = ((Button)this.iFK.findViewById(2131298560));
    this.vdz = ((PasterEditText)this.iFK.findViewById(2131298569));
    this.vdx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.this.dismiss();
        d.a(-1, 1, -1, "", 0, -1, -1, g.e(g.this), g.f(g.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25772);
      }
    });
    this.vdy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25773);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        g.g(g.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(25773);
      }
    });
    Object localObject1 = com.tencent.mm.plugin.ipcall.model.e.dgq();
    if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).uWd == null)
    {
      ae.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      com.tencent.mm.pluginsdk.j.a.a.b.fes();
      paramActivity = com.tencent.mm.pluginsdk.j.a.a.b.jq(39, 1);
      if (bu.isNullOrNil(paramActivity)) {
        break label558;
      }
      paramActivity = o.bb(paramActivity, 0, -1);
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.ipcall.model.e)localObject1).bp(paramActivity);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).uWd == null) {
        break label599;
      }
      paramActivity = ak.getContext().getSharedPreferences(ak.fow(), 0);
      ak.getContext();
      paramActivity = ad.g(paramActivity);
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
      Object localObject2 = ((com.tencent.mm.plugin.ipcall.model.e)localObject1).uWd.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramContext = (f)((Iterator)localObject2).next();
        if (paramActivity.equalsIgnoreCase(paramContext.vag))
        {
          ae.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).uWd.size()) });
          paramActivity = paramContext;
        }
      }
      for (;;)
      {
        if (paramActivity != null)
        {
          paramContext = paramActivity.vah;
          paramActivity = new ArrayList();
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.ipcall.model.h.e)paramContext.next();
              localObject2 = new a();
              ((a)localObject2).Id = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).Id;
              ((a)localObject2).urq = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).urq;
              ((a)localObject2).vdH = false;
              paramActivity.add(localObject2);
              continue;
              ae.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              ae.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              ae.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).uWd.size()) });
              paramActivity = null;
              break label460;
            }
          }
          this.mItemList = paramActivity;
          paramActivity = this.mItemList.iterator();
          while (paramActivity.hasNext())
          {
            paramContext = (a)paramActivity.next();
            localObject1 = this.vdw;
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setTextSize(0, getContext().getResources().getDimension(2131166295) * com.tencent.mm.cb.a.ef(getContext()));
            ((TextView)localObject2).setBackgroundResource(this.rHR);
            ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(this.rHQ));
            ((TextView)localObject2).setTag(paramContext);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setText(paramContext.urq);
            ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(25774);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                localObject = (g.a)paramAnonymousView.getTag();
                if (!((g.a)localObject).vdH) {}
                for (((g.a)localObject).vdH = true;; ((g.a)localObject).vdH = false)
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
      this.vdo = ((RelativeLayout)this.iFK.findViewById(2131301351));
      this.vdp = ((RelativeLayout)this.iFK.findViewById(2131301352));
      this.vdq = ((RelativeLayout)this.iFK.findViewById(2131301353));
      this.vdo.setOnClickListener(this.mOnClickListener);
      this.vdp.setOnClickListener(this.mOnClickListener);
      this.vdq.setOnClickListener(this.mOnClickListener);
      this.vdr = ((ImageView)this.iFK.findViewById(2131300980));
      this.vds = ((ImageView)this.iFK.findViewById(2131300981));
      this.vdt = ((ImageView)this.iFK.findViewById(2131300982));
      this.vdu = 0;
      Jf(this.vdu);
      this.vdA = ((Button)this.iFK.findViewById(2131301049));
      this.vdB = ((Button)this.iFK.findViewById(2131301050));
      this.vdC = ((TextView)this.iFK.findViewById(2131301052));
      paramActivity = c.dia();
      if (paramActivity != null) {}
      for (paramActivity = String.format(this.mContext.getString(2131760552), new Object[] { paramActivity.GYV });; paramActivity = null)
      {
        if (bu.isNullOrNil(paramActivity)) {
          this.vdC.setVisibility(4);
        }
        for (;;)
        {
          this.vdA.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25775);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              g.this.dismiss();
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, -1, 1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25775);
            }
          });
          this.vdB.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25776);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
              g.this.dismiss();
              localObject = new Intent();
              ((Intent)localObject).putExtra("IPCallShareCouponCardUI_KFrom", 2);
              ((Intent)localObject).setClass(g.i(g.this), IPCallShareCouponCardUI.class);
              paramAnonymousView = g.i(g.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, 1, -1, g.e(g.this), g.f(g.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(25776);
            }
          });
          this.kOy = ((ScrollView)this.iFK.findViewById(2131299891));
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
                ((g)localObject).iFK.postDelayed(new g.2((g)localObject), 100L);
              }
              AppMethodBeat.o(25769);
            }
          });
          AppMethodBeat.o(25778);
          return;
          this.vdC.setVisibility(0);
          this.vdC.setText(paramActivity);
        }
      }
    }
  }
  
  private void Jf(int paramInt)
  {
    AppMethodBeat.i(25780);
    this.vdu = paramInt;
    if (paramInt == 0)
    {
      this.vdr.setVisibility(4);
      this.vds.setVisibility(4);
      this.vdt.setVisibility(4);
      this.vdy.setEnabled(false);
      Ji(0);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 1)
    {
      this.vdr.setVisibility(0);
      this.vds.setVisibility(4);
      this.vdt.setVisibility(4);
      this.vdy.setEnabled(true);
      Ji(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 2)
    {
      this.vdr.setVisibility(0);
      this.vds.setVisibility(0);
      this.vdt.setVisibility(4);
      this.vdy.setEnabled(true);
      Ji(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 3)
    {
      this.vdr.setVisibility(0);
      this.vds.setVisibility(0);
      this.vdt.setVisibility(0);
      this.vdy.setEnabled(true);
      Ji(0);
    }
    AppMethodBeat.o(25780);
  }
  
  private String Jg(int paramInt)
  {
    AppMethodBeat.i(25781);
    String str = "";
    if (paramInt == 3)
    {
      AppMethodBeat.o(25781);
      return "";
    }
    if (!bu.isNullOrNil(this.vdz.getText().toString().trim())) {
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
        if (!((a)localObject).vdH) {
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
  
  private LinkedList<eca> Jh(int paramInt)
  {
    AppMethodBeat.i(25782);
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3)
    {
      AppMethodBeat.o(25782);
      return localLinkedList;
    }
    Object localObject1 = this.vdz.getText().toString().trim();
    Object localObject2;
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject2 = new eca();
      ((eca)localObject2).ID = 0;
      ((eca)localObject2).hFS = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.mItemList != null)
    {
      localObject1 = this.mItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (((a)localObject2).vdH)
        {
          eca localeca = new eca();
          try
          {
            localeca.ID = bu.getInt(((a)localObject2).Id, 0);
            localLinkedList.add(localeca);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ae.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + ((a)localObject2).Id);
          }
        }
      }
    }
    AppMethodBeat.o(25782);
    return localLinkedList;
  }
  
  private void Ji(int paramInt)
  {
    AppMethodBeat.i(25785);
    if (paramInt == 0)
    {
      this.vdm.setVisibility(0);
      this.vdn.setVisibility(4);
      if (this.vdj == 1)
      {
        ((LinearLayout.LayoutParams)this.vdv.getLayoutParams()).height = 0;
        this.vdv.requestLayout();
      }
      bu.hideVKB(this.iFK);
    }
    for (;;)
    {
      this.vdj = paramInt;
      AppMethodBeat.o(25785);
      return;
      if (paramInt == 1)
      {
        this.vdm.setVisibility(0);
        this.vdn.setVisibility(4);
        if (this.vdj == 0)
        {
          ((LinearLayout.LayoutParams)this.vdv.getLayoutParams()).height = -2;
          this.vdv.requestLayout();
          this.vdv.startAnimation(this.vdD);
        }
      }
      else if (paramInt == 2)
      {
        this.vdm.setVisibility(4);
        this.vdn.setVisibility(0);
        bu.hideVKB(this.iFK);
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
      ae.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(25784);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25779);
    super.onCreate(paramBundle);
    setContentView(this.iFK);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    Ji(0);
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
    public String urq;
    public boolean vdH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */