package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  extends BaseAdapter
{
  private String ikj;
  private e.a lOA;
  private View.OnClickListener lOB;
  private View.OnClickListener lOC;
  private View.OnClickListener lOD;
  List<e> lOu;
  Map<String, String> lOv;
  String lOw;
  d lOx;
  private String lOy;
  private boolean lOz;
  private Context mContext;
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(20097);
    this.lOz = false;
    this.lOA = new e.a();
    this.lOB = new b.2(this);
    this.lOC = new b.3(this);
    this.lOD = new b.4(this);
    this.ikj = r.Zn();
    this.mContext = paramContext;
    this.lOy = paramString;
    AppMethodBeat.o(20097);
  }
  
  private List<e> a(ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(20100);
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = h(this.ikj, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.lOA;
      ((e.a)localObject3).lRp = ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2);
      ((e.a)localObject3).lRq = 3;
      if (((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.a.b)g.E(com.tencent.mm.plugin.sport.a.b.class)).f((Activity)this.mContext, this.ikj);
      }
      if (!paramBoolean) {
        break label357;
      }
    }
    Object localObject4;
    label357:
    for (this.lOA.aoW = 2;; this.lOA.aoW = 1)
    {
      paramArrayList.add(this.lOA.brj());
      localObject2 = this.lOA;
      ((e.a)localObject2).aoW = 0;
      paramArrayList.add(((e.a)localObject2).brj());
      d((LinkedList)localObject1, this.ikj);
      localObject2 = new ArrayList();
      ab.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.f.b.a.d)((Iterator)localObject3).next();
        e.a locala = this.lOA;
        locala.lRp = ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject4);
        locala.aoW = 1;
        locala.lRq = 4;
        ((ArrayList)localObject2).add(locala.brj());
        if ((((LinkedList)localObject1).size() > 0) && (e((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject4).field_username)))
        {
          locala = this.lOA;
          locala.lRp = ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject4);
          locala.aoW = 1;
          locala.lRq = 2;
          paramArrayList.add(locala.brj());
          d((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.lOA;
      ((e.a)localObject2).lRp = null;
      ((e.a)localObject2).lOy = this.lOy;
      ((e.a)localObject2).username = this.ikj;
      ((e.a)localObject2).lRq = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.f.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.lOA;
        ((e.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject3).field_username;
        ((e.a)localObject4).lOy = this.lOy;
        ((e.a)localObject4).lRp = null;
        ((e.a)localObject4).aoW = 1;
        ((e.a)localObject4).lRq = 6;
        paramArrayList.add(((e.a)localObject4).brj());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((e)paramArrayList.get(paramArrayList.size() - 1)).lRq = (((e)paramArrayList.get(paramArrayList.size() - 1)).lRq | 0x2 | 0x1);
      localObject1 = this.lOA;
      ((e.a)localObject1).aoW = 0;
      ((e.a)localObject1).lRp = null;
      paramArrayList.add(((e.a)localObject1).brj());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((e)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).lRq = 5;
    }
    paramArrayList.addAll((Collection)localObject2);
    ab.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[] { Integer.valueOf(paramArrayList1.size()), paramArrayList1.toString() });
    ab.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[] { Integer.valueOf(paramArrayList.size()), paramArrayList.toString() });
    AppMethodBeat.o(20100);
    return paramArrayList;
  }
  
  private static void d(LinkedList<com.tencent.mm.plugin.exdevice.f.b.a.c> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(20098);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.f.b.a.c localc = (com.tencent.mm.plugin.exdevice.f.b.a.c)paramLinkedList.next();
      if (localc.field_username.equalsIgnoreCase(paramString))
      {
        ab.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[] { localc.toString() });
        paramLinkedList.remove();
      }
    }
    AppMethodBeat.o(20098);
  }
  
  private static boolean e(LinkedList<com.tencent.mm.plugin.exdevice.f.b.a.c> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(20099);
    try
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        boolean bool = ((com.tencent.mm.plugin.exdevice.f.b.a.c)paramLinkedList.next()).field_username.equalsIgnoreCase(paramString);
        if (bool)
        {
          AppMethodBeat.o(20099);
          return true;
        }
      }
      AppMethodBeat.o(20099);
      return false;
    }
    catch (Exception paramLinkedList)
    {
      ab.d("MicroMsg.ExdeviceRankAdapter", paramLinkedList.toString());
      AppMethodBeat.o(20099);
    }
    return false;
  }
  
  public static void finish()
  {
    AppMethodBeat.i(20106);
    ((com.tencent.mm.plugin.sport.a.b)g.E(com.tencent.mm.plugin.sport.a.b.class)).cyw();
    AppMethodBeat.o(20106);
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.a.d h(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList)
  {
    AppMethodBeat.i(20102);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(20102);
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.f.b.a.d locald = (com.tencent.mm.plugin.exdevice.f.b.a.d)paramArrayList.next();
      if (paramString.equalsIgnoreCase(locald.field_username))
      {
        AppMethodBeat.o(20102);
        return locald;
      }
    }
    AppMethodBeat.o(20102);
    return null;
  }
  
  public final List<e> b(ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(20101);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {}
    try
    {
      localObject = new ArrayList();
      paramArrayList = paramArrayList1;
      if (paramArrayList1 == null) {
        paramArrayList = new ArrayList();
      }
      paramArrayList = a((ArrayList)localObject, paramArrayList, paramBoolean);
      AppMethodBeat.o(20101);
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      ab.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
      paramArrayList = new ArrayList();
      AppMethodBeat.o(20101);
    }
    return paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(20103);
    if (this.lOu == null)
    {
      AppMethodBeat.o(20103);
      return 0;
    }
    int i = this.lOu.size();
    AppMethodBeat.o(20103);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(20105);
    paramInt = vg(paramInt).aoW;
    AppMethodBeat.o(20105);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(20107);
    com.tencent.mm.plugin.exdevice.f.b.a.d locald = vg(paramInt).lRp;
    Object localObject1 = vg(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((e)localObject1).lRq;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(this.mContext);
      switch (i)
      {
      default: 
        localObject1 = null;
        paramViewGroup = paramView;
        paramView = (View)localObject1;
        localObject1 = paramView;
        localObject2 = paramViewGroup;
        if (paramView != null)
        {
          paramView.gcq = paramViewGroup.findViewById(2131821084);
          paramView.jXt = paramViewGroup.findViewById(2131823590);
          paramView.lFO = ((TextView)paramViewGroup.findViewById(2131823835));
          paramView.lOG = ((ImageView)paramViewGroup.findViewById(2131823836));
          paramView.lOH = ((NoMeasuredTextView)paramViewGroup.findViewById(2131823839));
          paramView.lOJ = ((TextView)paramViewGroup.findViewById(2131823789));
          paramView.lOK = ((ExdeviceLikeView)paramViewGroup.findViewById(2131823838));
          paramView.lOL = paramViewGroup.findViewById(2131823841);
          paramView.lON = paramViewGroup.findViewById(2131823837);
          paramView.lOM = paramViewGroup.findViewById(2131823833);
          paramView.lOO = ((TextView)paramViewGroup.findViewById(2131823842));
          if (paramView.lOH != null)
          {
            paramView.lOH.setTextSize(0, this.mContext.getResources().getDimension(2131427627));
            paramView.lOH.setTextColor(this.mContext.getResources().getColor(2131690010));
            paramView.lOH.setSingleLine(true);
            paramView.lOH.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.ikj.equalsIgnoreCase(locald.field_username)) {
            break label572;
          }
        }
        break;
      }
    }
    label572:
    for (this.lOz = true;; this.lOz = false)
    {
      if (i != 2) {
        break label580;
      }
      ((b)localObject1).lFO.setText(String.valueOf(locald.field_ranknum));
      ((b)localObject1).lOJ.setText(String.valueOf(locald.field_score));
      a.b.s(((b)localObject1).lOG, locald.field_username);
      ((b)localObject1).gcq.setOnClickListener(this.lOC);
      ((b)localObject1).lOO.setOnClickListener(this.lOD);
      AppMethodBeat.o(20107);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2130969478, paramViewGroup, false);
      paramView = new b.a();
      paramView.gqg = paramViewGroup.findViewById(2131823841);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2130969477, paramViewGroup, false);
      paramView = new b();
      paramView.lOI = ((TextView)paramViewGroup.findViewById(2131823840));
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2130969479, paramViewGroup, false);
      paramView = new b();
      break;
      switch (i)
      {
      default: 
        localObject1 = null;
        localObject2 = paramView;
        break;
      case 1: 
      case 2: 
        localObject1 = (b)paramView.getTag();
        localObject2 = paramView;
        break;
      }
    }
    label580:
    if (((b)localObject1).lOI != null)
    {
      if ((j & 0x4) != 4)
      {
        ((b)localObject1).lOI.setVisibility(0);
        ((b)localObject1).lOI.setText(this.mContext.getResources().getString(2131299457, new Object[] { Integer.valueOf(locald.field_ranknum) }));
      }
    }
    else
    {
      if (((j & 0x2) == 2) || (!locald.field_username.equalsIgnoreCase(this.lOw)) || (this.ikj.equalsIgnoreCase(this.lOw))) {
        break label1070;
      }
      ((b)localObject1).jXt.setBackgroundColor(this.mContext.getResources().getColor(2131690004));
      if ((j & 0x1) != 1) {
        break label1094;
      }
      ((b)localObject1).lOL.setVisibility(8);
      label717:
      if (locald.field_ranknum < 100) {
        break label1106;
      }
      ((b)localObject1).lFO.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131427629));
      label750:
      if ((j & 0x2) != 2) {
        break label1132;
      }
      ((b)localObject1).lFO.setText("");
      if (locald.field_score < 10000) {
        break label1161;
      }
      ((b)localObject1).lOJ.setTextColor(this.mContext.getResources().getColor(2131690009));
      ((b)localObject1).lOJ.setText(String.valueOf(locald.field_score));
      a.b.s(((b)localObject1).lOG, locald.field_username);
      if (this.lOz) {
        break label1185;
      }
      aw.aaz();
      if ((com.tencent.mm.model.c.YA().arr(locald.field_username)) || (this.lOv == null) || (bo.isNullOrNil((String)this.lOv.get(locald.field_username)))) {
        break label1185;
      }
      ((b)localObject1).lOH.setText(j.b(this.mContext, (CharSequence)this.lOv.get(locald.field_username), ((b)localObject1).lOH.getTextSize()));
      ((b)localObject1).lOK.setLikeNum(locald.field_likecount);
      if (!this.lOz) {
        break label1231;
      }
      if (locald.field_likecount == 0) {
        break label1219;
      }
      ((b)localObject1).lOK.setSelfLikeState(1);
      label964:
      if ((locald.field_score <= 0) && (!this.lOz)) {
        break label1247;
      }
      ((b)localObject1).lOK.setClickable(true);
      ((b)localObject1).lOK.setOnLikeViewClickListener(new b.1(this, locald));
    }
    for (;;)
    {
      label641:
      label699:
      ((b)localObject1).lOM.setTag(Integer.valueOf(paramInt));
      label769:
      label801:
      ((b)localObject1).lOM.setOnClickListener(this.lOB);
      label927:
      ((b)localObject1).lON.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).lON.setOnClickListener(this.lOB);
      break;
      ((b)localObject1).lOI.setVisibility(8);
      break label641;
      label1070:
      ((b)localObject1).jXt.setBackgroundColor(this.mContext.getResources().getColor(2131690003));
      break label699;
      label1094:
      ((b)localObject1).lOL.setVisibility(0);
      break label717;
      label1106:
      ((b)localObject1).lFO.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131427628));
      break label750;
      label1132:
      ((b)localObject1).lFO.setText(locald.field_ranknum);
      break label769;
      label1161:
      ((b)localObject1).lOJ.setTextColor(this.mContext.getResources().getColor(2131690008));
      break label801;
      label1185:
      ((b)localObject1).lOH.setText(j.b(this.mContext, s.nE(locald.field_username), ((b)localObject1).lOH.getTextSize()));
      break label927;
      label1219:
      ((b)localObject1).lOK.setSelfLikeState(0);
      break label964;
      label1231:
      ((b)localObject1).lOK.setSelfLikeState(locald.field_selfLikeState);
      break label964;
      label1247:
      ((b)localObject1).lOK.setClickable(false);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  public final e vg(int paramInt)
  {
    AppMethodBeat.i(20104);
    e locale = (e)this.lOu.get(paramInt);
    AppMethodBeat.o(20104);
    return locale;
  }
  
  static final class b
  {
    public View gcq;
    public View jXt;
    public TextView lFO;
    public ImageView lOG;
    public NoMeasuredTextView lOH;
    public TextView lOI;
    public TextView lOJ;
    public ExdeviceLikeView lOK;
    public View lOL;
    public View lOM;
    public View lON;
    public TextView lOO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */