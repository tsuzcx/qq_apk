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
import com.tencent.mm.pluginsdk.h.a.a.b;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends com.tencent.mm.ui.base.i
{
  private CharSequence Fm;
  View ijA;
  private ScrollView kqh;
  private Activity mActivity;
  private Context mContext;
  private ao mHandler;
  private ArrayList<a> mItemList;
  private View.OnClickListener mOnClickListener;
  private int qPG;
  private int qPH;
  private int tOK;
  private int tOL;
  private long tOM;
  private LinearLayout tON;
  private LinearLayout tOO;
  private RelativeLayout tOP;
  private RelativeLayout tOQ;
  private RelativeLayout tOR;
  private ImageView tOS;
  private ImageView tOT;
  private ImageView tOU;
  private int tOV;
  private FrameLayout tOW;
  private FlowLayout tOX;
  private Button tOY;
  private Button tOZ;
  private PasterEditText tPa;
  private Button tPb;
  private Button tPc;
  private TextView tPd;
  private Animation tPe;
  private int tPf;
  private int tPg;
  
  public g(final Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(25778);
    this.tOK = 0;
    this.mHandler = new ao();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25771);
        if (paramAnonymousView == g.b(g.this))
        {
          g.a(g.this, 1);
          AppMethodBeat.o(25771);
          return;
        }
        if (paramAnonymousView == g.c(g.this))
        {
          g.a(g.this, 2);
          AppMethodBeat.o(25771);
          return;
        }
        if (paramAnonymousView == g.d(g.this)) {
          g.a(g.this, 3);
        }
        AppMethodBeat.o(25771);
      }
    };
    this.qPH = 2131232305;
    this.qPG = 2131100367;
    this.tPf = 2131232302;
    this.tPg = 2131101182;
    setCancelable(false);
    this.mContext = paramContext;
    this.tOL = paramInt;
    this.tOM = paramLong;
    this.mActivity = paramActivity;
    this.ijA = View.inflate(this.mContext, 2131494514, null);
    this.tON = ((LinearLayout)this.ijA.findViewById(2131301346));
    this.tOO = ((LinearLayout)this.ijA.findViewById(2131301347));
    this.tPe = AnimationUtils.loadAnimation(ai.getContext(), 2130771981);
    this.tPe.setDuration(200L);
    this.tPe.setStartOffset(100L);
    this.tOW = ((FrameLayout)this.ijA.findViewById(2131300141));
    this.tOX = ((FlowLayout)this.ijA.findViewById(2131300140));
    this.tOY = ((Button)this.ijA.findViewById(2131298559));
    this.tOZ = ((Button)this.ijA.findViewById(2131298560));
    this.tPa = ((PasterEditText)this.ijA.findViewById(2131298569));
    this.tOY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25772);
        g.this.dismiss();
        d.a(-1, 1, -1, "", 0, -1, -1, g.e(g.this), g.f(g.this));
        AppMethodBeat.o(25772);
      }
    });
    this.tOZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25773);
        g.g(g.this);
        AppMethodBeat.o(25773);
      }
    });
    Object localObject1 = com.tencent.mm.plugin.ipcall.model.e.cUn();
    if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).tHD == null)
    {
      ac.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      b.eLH();
      paramActivity = b.ja(39, 1);
      if (bs.isNullOrNil(paramActivity)) {
        break label558;
      }
      paramActivity = com.tencent.mm.vfs.i.aU(paramActivity, 0, -1);
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.ipcall.model.e)localObject1).bn(paramActivity);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.model.e)localObject1).tHD == null) {
        break label599;
      }
      paramActivity = ai.getContext().getSharedPreferences(ai.eUX(), 0);
      ai.getContext();
      paramActivity = ab.g(paramActivity);
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
      Object localObject2 = ((com.tencent.mm.plugin.ipcall.model.e)localObject1).tHD.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramContext = (f)((Iterator)localObject2).next();
        if (paramActivity.equalsIgnoreCase(paramContext.tLH))
        {
          ac.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).tHD.size()) });
          paramActivity = paramContext;
        }
      }
      for (;;)
      {
        if (paramActivity != null)
        {
          paramContext = paramActivity.tLI;
          paramActivity = new ArrayList();
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.ipcall.model.h.e)paramContext.next();
              localObject2 = new a();
              ((a)localObject2).Id = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).Id;
              ((a)localObject2).tLG = ((com.tencent.mm.plugin.ipcall.model.h.e)localObject1).tLG;
              ((a)localObject2).tPi = false;
              paramActivity.add(localObject2);
              continue;
              ac.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              ac.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              ac.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.model.e)localObject1).tHD.size()) });
              paramActivity = null;
              break label460;
            }
          }
          this.mItemList = paramActivity;
          paramActivity = this.mItemList.iterator();
          while (paramActivity.hasNext())
          {
            paramContext = (a)paramActivity.next();
            localObject1 = this.tOX;
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setTextSize(0, getContext().getResources().getDimension(2131166295) * com.tencent.mm.cc.a.eb(getContext()));
            ((TextView)localObject2).setBackgroundResource(this.qPH);
            ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(this.qPG));
            ((TextView)localObject2).setTag(paramContext);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setText(paramContext.tLG);
            ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(25774);
                g.a locala = (g.a)paramAnonymousView.getTag();
                if (!locala.tPi) {}
                for (locala.tPi = true;; locala.tPi = false)
                {
                  g.a(g.this, (TextView)paramAnonymousView);
                  AppMethodBeat.o(25774);
                  return;
                }
              }
            });
            ((FlowLayout)localObject1).addView((View)localObject2);
          }
        }
      }
      this.tOP = ((RelativeLayout)this.ijA.findViewById(2131301351));
      this.tOQ = ((RelativeLayout)this.ijA.findViewById(2131301352));
      this.tOR = ((RelativeLayout)this.ijA.findViewById(2131301353));
      this.tOP.setOnClickListener(this.mOnClickListener);
      this.tOQ.setOnClickListener(this.mOnClickListener);
      this.tOR.setOnClickListener(this.mOnClickListener);
      this.tOS = ((ImageView)this.ijA.findViewById(2131300980));
      this.tOT = ((ImageView)this.ijA.findViewById(2131300981));
      this.tOU = ((ImageView)this.ijA.findViewById(2131300982));
      this.tOV = 0;
      Hl(this.tOV);
      this.tPb = ((Button)this.ijA.findViewById(2131301049));
      this.tPc = ((Button)this.ijA.findViewById(2131301050));
      this.tPd = ((TextView)this.ijA.findViewById(2131301052));
      paramActivity = c.cVX();
      if (paramActivity != null) {}
      for (paramActivity = String.format(this.mContext.getString(2131760552), new Object[] { paramActivity.EVW });; paramActivity = null)
      {
        if (bs.isNullOrNil(paramActivity)) {
          this.tPd.setVisibility(4);
        }
        for (;;)
        {
          this.tPb.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25775);
              g.this.dismiss();
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, -1, 1, g.e(g.this), g.f(g.this));
              AppMethodBeat.o(25775);
            }
          });
          this.tPc.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(25776);
              g.this.dismiss();
              Object localObject = new Intent();
              ((Intent)localObject).putExtra("IPCallShareCouponCardUI_KFrom", 2);
              ((Intent)localObject).setClass(g.i(g.this), IPCallShareCouponCardUI.class);
              paramAnonymousView = g.i(g.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              d.a(1, -1, g.h(g.this), g.b(g.this, g.h(g.this)), 1, 1, -1, g.e(g.this), g.f(g.this));
              AppMethodBeat.o(25776);
            }
          });
          this.kqh = ((ScrollView)this.ijA.findViewById(2131299891));
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
                ((g)localObject).ijA.postDelayed(new g.2((g)localObject), 100L);
              }
              AppMethodBeat.o(25769);
            }
          });
          AppMethodBeat.o(25778);
          return;
          this.tPd.setVisibility(0);
          this.tPd.setText(paramActivity);
        }
      }
    }
  }
  
  private void Hl(int paramInt)
  {
    AppMethodBeat.i(25780);
    this.tOV = paramInt;
    if (paramInt == 0)
    {
      this.tOS.setVisibility(4);
      this.tOT.setVisibility(4);
      this.tOU.setVisibility(4);
      this.tOZ.setEnabled(false);
      Ho(0);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 1)
    {
      this.tOS.setVisibility(0);
      this.tOT.setVisibility(4);
      this.tOU.setVisibility(4);
      this.tOZ.setEnabled(true);
      Ho(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 2)
    {
      this.tOS.setVisibility(0);
      this.tOT.setVisibility(0);
      this.tOU.setVisibility(4);
      this.tOZ.setEnabled(true);
      Ho(1);
      AppMethodBeat.o(25780);
      return;
    }
    if (paramInt == 3)
    {
      this.tOS.setVisibility(0);
      this.tOT.setVisibility(0);
      this.tOU.setVisibility(0);
      this.tOZ.setEnabled(true);
      Ho(0);
    }
    AppMethodBeat.o(25780);
  }
  
  private String Hm(int paramInt)
  {
    AppMethodBeat.i(25781);
    String str = "";
    if (paramInt == 3)
    {
      AppMethodBeat.o(25781);
      return "";
    }
    if (!bs.isNullOrNil(this.tPa.getText().toString().trim())) {
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
        if (!((a)localObject).tPi) {
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
  
  private LinkedList<dup> Hn(int paramInt)
  {
    AppMethodBeat.i(25782);
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3)
    {
      AppMethodBeat.o(25782);
      return localLinkedList;
    }
    Object localObject1 = this.tPa.getText().toString().trim();
    Object localObject2;
    if (!bs.isNullOrNil((String)localObject1))
    {
      localObject2 = new dup();
      ((dup)localObject2).ID = 0;
      ((dup)localObject2).hkR = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.mItemList != null)
    {
      localObject1 = this.mItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (((a)localObject2).tPi)
        {
          dup localdup = new dup();
          try
          {
            localdup.ID = bs.getInt(((a)localObject2).Id, 0);
            localLinkedList.add(localdup);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ac.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + ((a)localObject2).Id);
          }
        }
      }
    }
    AppMethodBeat.o(25782);
    return localLinkedList;
  }
  
  private void Ho(int paramInt)
  {
    AppMethodBeat.i(25785);
    if (paramInt == 0)
    {
      this.tON.setVisibility(0);
      this.tOO.setVisibility(4);
      if (this.tOK == 1)
      {
        ((LinearLayout.LayoutParams)this.tOW.getLayoutParams()).height = 0;
        this.tOW.requestLayout();
      }
      bs.hideVKB(this.ijA);
    }
    for (;;)
    {
      this.tOK = paramInt;
      AppMethodBeat.o(25785);
      return;
      if (paramInt == 1)
      {
        this.tON.setVisibility(0);
        this.tOO.setVisibility(4);
        if (this.tOK == 0)
        {
          ((LinearLayout.LayoutParams)this.tOW.getLayoutParams()).height = -2;
          this.tOW.requestLayout();
          this.tOW.startAnimation(this.tPe);
        }
      }
      else if (paramInt == 2)
      {
        this.tON.setVisibility(4);
        this.tOO.setVisibility(0);
        bs.hideVKB(this.ijA);
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
      ac.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(25784);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25779);
    super.onCreate(paramBundle);
    setContentView(this.ijA);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    Ho(0);
    AppMethodBeat.o(25779);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Fm = paramCharSequence;
      return;
    }
    this.Fm = null;
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
    public String tLG;
    public boolean tPi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */