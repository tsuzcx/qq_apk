package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g
  extends i
{
  private CharSequence Cv;
  private ScrollView hLr;
  View iCk;
  private Activity mActivity;
  private Context mContext;
  private ak mHandler;
  private ArrayList<g.a> mItemList;
  private View.OnClickListener mOnClickListener;
  private int mzB;
  private int mzC;
  private Button nTA;
  private TextView nTB;
  private Animation nTC;
  private int nTD;
  private int nTE;
  private int nTi;
  private int nTj;
  private long nTk;
  private LinearLayout nTl;
  private LinearLayout nTm;
  private RelativeLayout nTn;
  private RelativeLayout nTo;
  private RelativeLayout nTp;
  private ImageView nTq;
  private ImageView nTr;
  private ImageView nTs;
  private int nTt;
  private FrameLayout nTu;
  private FlowLayout nTv;
  private Button nTw;
  private Button nTx;
  private PasterEditText nTy;
  private Button nTz;
  
  public g(Activity paramActivity, Context paramContext, int paramInt, long paramLong)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(22160);
    this.nTi = 0;
    this.mHandler = new ak();
    this.mOnClickListener = new g.3(this);
    this.mzC = 2130838849;
    this.mzB = 2131690066;
    this.nTD = 2130838846;
    this.nTE = 2131690711;
    setCancelable(false);
    this.mContext = paramContext;
    this.nTj = paramInt;
    this.nTk = paramLong;
    this.mActivity = paramActivity;
    this.iCk = View.inflate(this.mContext, 2130969936, null);
    this.nTl = ((LinearLayout)this.iCk.findViewById(2131825278));
    this.nTm = ((LinearLayout)this.iCk.findViewById(2131825289));
    this.nTC = AnimationUtils.loadAnimation(ah.getContext(), 2131034125);
    this.nTC.setDuration(200L);
    this.nTC.setStartOffset(100L);
    this.nTu = ((FrameLayout)this.iCk.findViewById(2131825285));
    this.nTv = ((FlowLayout)this.iCk.findViewById(2131825286));
    this.nTw = ((Button)this.iCk.findViewById(2131825287));
    this.nTx = ((Button)this.iCk.findViewById(2131825288));
    this.nTy = ((PasterEditText)this.iCk.findViewById(2131822990));
    this.nTw.setOnClickListener(new g.4(this));
    this.nTx.setOnClickListener(new g.5(this));
    Object localObject1 = com.tencent.mm.plugin.ipcall.a.e.bJg();
    if (((com.tencent.mm.plugin.ipcall.a.e)localObject1).nMb == null)
    {
      ab.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
      b.c.dmg();
      paramActivity = b.hc(39, 1);
      if (bo.isNullOrNil(paramActivity)) {
        break label558;
      }
      paramActivity = com.tencent.mm.a.e.j(paramActivity, 0, -1);
      if (paramActivity != null) {
        ((com.tencent.mm.plugin.ipcall.a.e)localObject1).aY(paramActivity);
      }
    }
    else
    {
      if (((com.tencent.mm.plugin.ipcall.a.e)localObject1).nMb == null) {
        break label599;
      }
      paramActivity = ah.getContext().getSharedPreferences(ah.dsP(), 0);
      ah.getContext();
      paramActivity = aa.g(paramActivity);
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
      Object localObject2 = ((com.tencent.mm.plugin.ipcall.a.e)localObject1).nMb.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramContext = (f)((Iterator)localObject2).next();
        if (paramActivity.equalsIgnoreCase(paramContext.nQf))
        {
          ab.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.e)localObject1).nMb.size()) });
          paramActivity = paramContext;
        }
      }
      for (;;)
      {
        if (paramActivity != null)
        {
          paramContext = paramActivity.nQg;
          paramActivity = new ArrayList();
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              localObject1 = (com.tencent.mm.plugin.ipcall.a.g.e)paramContext.next();
              localObject2 = new g.a();
              ((g.a)localObject2).Id = ((com.tencent.mm.plugin.ipcall.a.g.e)localObject1).Id;
              ((g.a)localObject2).nQe = ((com.tencent.mm.plugin.ipcall.a.g.e)localObject1).nQe;
              ((g.a)localObject2).nTG = false;
              paramActivity.add(localObject2);
              continue;
              ab.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
              break;
              ab.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
              break;
              ab.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[] { paramActivity, Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.e)localObject1).nMb.size()) });
              paramActivity = null;
              break label460;
            }
          }
          this.mItemList = paramActivity;
          paramActivity = this.mItemList.iterator();
          while (paramActivity.hasNext())
          {
            paramContext = (g.a)paramActivity.next();
            localObject1 = this.nTv;
            localObject2 = new TextView(getContext());
            ((TextView)localObject2).setTextSize(0, getContext().getResources().getDimension(2131428424) * a.dr(getContext()));
            ((TextView)localObject2).setBackgroundResource(this.mzC);
            ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(this.mzB));
            ((TextView)localObject2).setTag(paramContext);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject2).setSingleLine();
            ((TextView)localObject2).setText(paramContext.nQe);
            ((TextView)localObject2).setOnClickListener(new g.6(this));
            ((FlowLayout)localObject1).addView((View)localObject2);
          }
        }
      }
      this.nTn = ((RelativeLayout)this.iCk.findViewById(2131825279));
      this.nTo = ((RelativeLayout)this.iCk.findViewById(2131825281));
      this.nTp = ((RelativeLayout)this.iCk.findViewById(2131825283));
      this.nTn.setOnClickListener(this.mOnClickListener);
      this.nTo.setOnClickListener(this.mOnClickListener);
      this.nTp.setOnClickListener(this.mOnClickListener);
      this.nTq = ((ImageView)this.iCk.findViewById(2131825280));
      this.nTr = ((ImageView)this.iCk.findViewById(2131825282));
      this.nTs = ((ImageView)this.iCk.findViewById(2131825284));
      this.nTt = 0;
      xO(this.nTt);
      this.nTz = ((Button)this.iCk.findViewById(2131825292));
      this.nTA = ((Button)this.iCk.findViewById(2131825293));
      this.nTB = ((TextView)this.iCk.findViewById(2131825291));
      paramActivity = c.bKP();
      if (paramActivity != null) {}
      for (paramActivity = String.format(this.mContext.getString(2131300951), new Object[] { paramActivity.xhw });; paramActivity = null)
      {
        if (bo.isNullOrNil(paramActivity)) {
          this.nTB.setVisibility(4);
        }
        for (;;)
        {
          this.nTz.setOnClickListener(new g.7(this));
          this.nTA.setOnClickListener(new g.8(this));
          this.hLr = ((ScrollView)this.iCk.findViewById(2131825277));
          paramActivity = ((ViewGroup)this.mActivity.findViewById(16908290)).getChildAt(0);
          paramActivity.getViewTreeObserver().addOnGlobalLayoutListener(new g.1(this, paramActivity));
          AppMethodBeat.o(22160);
          return;
          this.nTB.setVisibility(0);
          this.nTB.setText(paramActivity);
        }
      }
    }
  }
  
  private void xO(int paramInt)
  {
    AppMethodBeat.i(22162);
    this.nTt = paramInt;
    if (paramInt == 0)
    {
      this.nTq.setVisibility(4);
      this.nTr.setVisibility(4);
      this.nTs.setVisibility(4);
      this.nTx.setEnabled(false);
      xR(0);
      AppMethodBeat.o(22162);
      return;
    }
    if (paramInt == 1)
    {
      this.nTq.setVisibility(0);
      this.nTr.setVisibility(4);
      this.nTs.setVisibility(4);
      this.nTx.setEnabled(true);
      xR(1);
      AppMethodBeat.o(22162);
      return;
    }
    if (paramInt == 2)
    {
      this.nTq.setVisibility(0);
      this.nTr.setVisibility(0);
      this.nTs.setVisibility(4);
      this.nTx.setEnabled(true);
      xR(1);
      AppMethodBeat.o(22162);
      return;
    }
    if (paramInt == 3)
    {
      this.nTq.setVisibility(0);
      this.nTr.setVisibility(0);
      this.nTs.setVisibility(0);
      this.nTx.setEnabled(true);
      xR(0);
    }
    AppMethodBeat.o(22162);
  }
  
  private String xP(int paramInt)
  {
    AppMethodBeat.i(22164);
    String str = "";
    if (paramInt == 3)
    {
      AppMethodBeat.o(22164);
      return "";
    }
    if (!bo.isNullOrNil(this.nTy.getText().toString().trim())) {
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
        localObject = (g.a)localIterator.next();
        if (!((g.a)localObject).nTG) {
          break label153;
        }
        if (!str.equals("")) {
          break;
        }
        str = ((g.a)localObject).Id;
      }
      str = str + "_" + ((g.a)localObject).Id;
    }
    label145:
    label153:
    for (;;)
    {
      break;
      localObject = str;
      AppMethodBeat.o(22164);
      return localObject;
    }
  }
  
  private LinkedList<cux> xQ(int paramInt)
  {
    AppMethodBeat.i(22165);
    LinkedList localLinkedList = new LinkedList();
    if (paramInt == 3)
    {
      AppMethodBeat.o(22165);
      return localLinkedList;
    }
    Object localObject1 = this.nTy.getText().toString().trim();
    Object localObject2;
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject2 = new cux();
      ((cux)localObject2).ID = 0;
      ((cux)localObject2).ntu = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (this.mItemList != null)
    {
      localObject1 = this.mItemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (g.a)((Iterator)localObject1).next();
        if (((g.a)localObject2).nTG)
        {
          cux localcux = new cux();
          try
          {
            localcux.ID = bo.getInt(((g.a)localObject2).Id, 0);
            localLinkedList.add(localcux);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ab.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + ((g.a)localObject2).Id);
          }
        }
      }
    }
    AppMethodBeat.o(22165);
    return localLinkedList;
  }
  
  private void xR(int paramInt)
  {
    AppMethodBeat.i(22168);
    if (paramInt == 0)
    {
      this.nTl.setVisibility(0);
      this.nTm.setVisibility(4);
      if (this.nTi == 1)
      {
        ((LinearLayout.LayoutParams)this.nTu.getLayoutParams()).height = 0;
        this.nTu.requestLayout();
      }
      bo.hideVKB(this.iCk);
    }
    for (;;)
    {
      this.nTi = paramInt;
      AppMethodBeat.o(22168);
      return;
      if (paramInt == 1)
      {
        this.nTl.setVisibility(0);
        this.nTm.setVisibility(4);
        if (this.nTi == 0)
        {
          ((LinearLayout.LayoutParams)this.nTu.getLayoutParams()).height = -2;
          this.nTu.requestLayout();
          this.nTu.startAnimation(this.nTC);
        }
      }
      else if (paramInt == 2)
      {
        this.nTl.setVisibility(4);
        this.nTm.setVisibility(0);
        bo.hideVKB(this.iCk);
      }
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(22167);
    try
    {
      super.dismiss();
      AppMethodBeat.o(22167);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(22167);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22161);
    super.onCreate(paramBundle);
    setContentView(this.iCk);
    getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    xR(0);
    AppMethodBeat.o(22161);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Cv = paramCharSequence;
      return;
    }
    this.Cv = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(22166);
    super.show();
    AppMethodBeat.o(22166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g
 * JD-Core Version:    0.7.0.1
 */