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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private String hcm = q.Gj();
  List<e> jEW;
  Map<String, String> jEX;
  String jEY;
  d jEZ;
  private String jFa;
  private boolean jFb = false;
  private e.a jFc = new e.a();
  private View.OnClickListener jFd = new b.2(this);
  private View.OnClickListener jFe = new b.3(this);
  private View.OnClickListener jFf = new b.4(this);
  private Context mContext;
  
  public b(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.jFa = paramString;
  }
  
  private List<e> a(ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = f(this.hcm, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.jFc;
      ((e.a)localObject3).jHR = ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2);
      ((e.a)localObject3).jHS = 3;
      if (((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.b.b)g.r(com.tencent.mm.plugin.sport.b.b.class)).d((Activity)this.mContext, this.hcm);
      }
      if (!paramBoolean) {
        break label351;
      }
    }
    Object localObject4;
    label351:
    for (this.jFc.amH = 2;; this.jFc.amH = 1)
    {
      paramArrayList.add(this.jFc.aMV());
      localObject2 = this.jFc;
      ((e.a)localObject2).amH = 0;
      paramArrayList.add(((e.a)localObject2).aMV());
      d((LinkedList)localObject1, this.hcm);
      localObject2 = new ArrayList();
      y.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.f.b.a.d)((Iterator)localObject3).next();
        e.a locala = this.jFc;
        locala.jHR = ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject4);
        locala.amH = 1;
        locala.jHS = 4;
        ((ArrayList)localObject2).add(locala.aMV());
        if ((((LinkedList)localObject1).size() > 0) && (e((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject4).field_username)))
        {
          locala = this.jFc;
          locala.jHR = ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject4);
          locala.amH = 1;
          locala.jHS = 2;
          paramArrayList.add(locala.aMV());
          d((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.f.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.jFc;
      ((e.a)localObject2).jHR = null;
      ((e.a)localObject2).jFa = this.jFa;
      ((e.a)localObject2).username = this.hcm;
      ((e.a)localObject2).jHS = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.f.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.jFc;
        ((e.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.f.b.a.c)localObject3).field_username;
        ((e.a)localObject4).jFa = this.jFa;
        ((e.a)localObject4).jHR = null;
        ((e.a)localObject4).amH = 1;
        ((e.a)localObject4).jHS = 6;
        paramArrayList.add(((e.a)localObject4).aMV());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((e)paramArrayList.get(paramArrayList.size() - 1)).jHS = (((e)paramArrayList.get(paramArrayList.size() - 1)).jHS | 0x2 | 0x1);
      localObject1 = this.jFc;
      ((e.a)localObject1).amH = 0;
      ((e.a)localObject1).jHR = null;
      paramArrayList.add(((e.a)localObject1).aMV());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((e)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).jHS = 5;
    }
    paramArrayList.addAll((Collection)localObject2);
    y.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[] { Integer.valueOf(paramArrayList1.size()), paramArrayList1.toString() });
    y.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[] { Integer.valueOf(paramArrayList.size()), paramArrayList.toString() });
    return paramArrayList;
  }
  
  private static void d(LinkedList<com.tencent.mm.plugin.exdevice.f.b.a.c> paramLinkedList, String paramString)
  {
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.f.b.a.c localc = (com.tencent.mm.plugin.exdevice.f.b.a.c)paramLinkedList.next();
      if (localc.field_username.equalsIgnoreCase(paramString))
      {
        y.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[] { localc.toString() });
        paramLinkedList.remove();
      }
    }
  }
  
  private static boolean e(LinkedList<com.tencent.mm.plugin.exdevice.f.b.a.c> paramLinkedList, String paramString)
  {
    try
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        boolean bool = ((com.tencent.mm.plugin.exdevice.f.b.a.c)paramLinkedList.next()).field_username.equalsIgnoreCase(paramString);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramLinkedList)
    {
      y.d("MicroMsg.ExdeviceRankAdapter", paramLinkedList.toString());
    }
    return false;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.a.d f(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.f.b.a.d locald = (com.tencent.mm.plugin.exdevice.f.b.a.d)paramArrayList.next();
      if (paramString.equalsIgnoreCase(locald.field_username)) {
        return locald;
      }
    }
    return null;
  }
  
  public static void finish()
  {
    ((com.tencent.mm.plugin.sport.b.b)g.r(com.tencent.mm.plugin.sport.b.b.class)).bLa();
  }
  
  public final List<e> b(ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> paramArrayList1, boolean paramBoolean)
  {
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
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      y.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
    }
    return new ArrayList();
  }
  
  public final int getCount()
  {
    if (this.jEW == null) {
      return 0;
    }
    return this.jEW.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return qz(paramInt).amH;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.exdevice.f.b.a.d locald = qz(paramInt).jHR;
    Object localObject1 = qz(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((e)localObject1).jHS;
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
          paramView.eML = paramViewGroup.findViewById(R.h.container);
          paramView.ifC = paramViewGroup.findViewById(R.h.item_content);
          paramView.jwp = ((TextView)paramViewGroup.findViewById(R.h.exdevice_rank_tv));
          paramView.jFi = ((ImageView)paramViewGroup.findViewById(R.h.exdevice_user_icon));
          paramView.jFj = ((NoMeasuredTextView)paramViewGroup.findViewById(R.h.exdevice_user_name));
          paramView.jFl = ((TextView)paramViewGroup.findViewById(R.h.ex_device_user_score));
          paramView.jFm = ((ExdeviceLikeView)paramViewGroup.findViewById(R.h.exdevice_likeview));
          paramView.jFn = paramViewGroup.findViewById(R.h.dividerV);
          paramView.jFp = paramViewGroup.findViewById(R.h.exdevice_user_name_score_layout);
          paramView.jFo = paramViewGroup.findViewById(R.h.exdevice_avatar_layout);
          paramView.jFq = ((TextView)paramViewGroup.findViewById(R.h.share_step_tv));
          if (paramView.jFj != null)
          {
            paramView.jFj.setTextSize(0, this.mContext.getResources().getDimension(R.f.ExdeviceRankInfoUserName));
            paramView.jFj.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_user_name));
            paramView.jFj.setSingleLine(true);
            paramView.jFj.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.hcm.equalsIgnoreCase(locald.field_username)) {
            break label560;
          }
        }
        break;
      }
    }
    label560:
    for (this.jFb = true;; this.jFb = false)
    {
      if (i != 2) {
        break label568;
      }
      ((b.b)localObject1).jwp.setText(String.valueOf(locald.field_ranknum));
      ((b.b)localObject1).jFl.setText(String.valueOf(locald.field_score));
      a.b.n(((b.b)localObject1).jFi, locald.field_username);
      ((b.b)localObject1).eML.setOnClickListener(this.jFe);
      ((b.b)localObject1).jFq.setOnClickListener(this.jFf);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.exdevice_rank_info_item_other_divider, paramViewGroup, false);
      paramView = new b.a();
      paramView.eYp = paramViewGroup.findViewById(R.h.dividerV);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.exdevice_rank_info_item_other, paramViewGroup, false);
      paramView = new b.b();
      paramView.jFk = ((TextView)paramViewGroup.findViewById(R.h.exdevice_user_name_below_ranknum));
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.exdevice_rank_profile_item, paramViewGroup, false);
      paramView = new b.b();
      break;
      switch (i)
      {
      default: 
        localObject1 = null;
        localObject2 = paramView;
        break;
      case 1: 
      case 2: 
        localObject1 = (b.b)paramView.getTag();
        localObject2 = paramView;
        break;
      }
    }
    label568:
    if (((b.b)localObject1).jFk != null)
    {
      if ((j & 0x4) != 4)
      {
        ((b.b)localObject1).jFk.setVisibility(0);
        ((b.b)localObject1).jFk.setText(this.mContext.getResources().getString(R.l.exdevice_rank_my_ranking, new Object[] { Integer.valueOf(locald.field_ranknum) }));
      }
    }
    else
    {
      if (((j & 0x2) == 2) || (!locald.field_username.equalsIgnoreCase(this.jEY)) || (this.hcm.equalsIgnoreCase(this.jEY))) {
        break label1058;
      }
      ((b.b)localObject1).ifC.setBackgroundColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_info_hight_user_bg));
      if ((j & 0x1) != 1) {
        break label1082;
      }
      ((b.b)localObject1).jFn.setVisibility(8);
      label705:
      if (locald.field_ranknum < 100) {
        break label1094;
      }
      ((b.b)localObject1).jwp.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.f.ExdeviceRankNumberOverFontSize));
      label738:
      if ((j & 0x2) != 2) {
        break label1120;
      }
      ((b.b)localObject1).jwp.setText("");
      label757:
      if (locald.field_score < 10000) {
        break label1149;
      }
      ((b.b)localObject1).jFl.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_up_step));
      ((b.b)localObject1).jFl.setText(String.valueOf(locald.field_score));
      a.b.n(((b.b)localObject1).jFi, locald.field_username);
      if (this.jFb) {
        break label1173;
      }
      au.Hx();
      if ((com.tencent.mm.model.c.Fw().abg(locald.field_username)) || (this.jEX == null) || (bk.bl((String)this.jEX.get(locald.field_username)))) {
        break label1173;
      }
      ((b.b)localObject1).jFj.setText(j.a(this.mContext, (CharSequence)this.jEX.get(locald.field_username), ((b.b)localObject1).jFj.getTextSize()));
      ((b.b)localObject1).jFm.setLikeNum(locald.field_likecount);
      if (!this.jFb) {
        break label1219;
      }
      if (locald.field_likecount == 0) {
        break label1207;
      }
      ((b.b)localObject1).jFm.setSelfLikeState(1);
      label952:
      if ((locald.field_score <= 0) && (!this.jFb)) {
        break label1235;
      }
      ((b.b)localObject1).jFm.setClickable(true);
      ((b.b)localObject1).jFm.setOnLikeViewClickListener(new b.1(this, locald));
    }
    for (;;)
    {
      label687:
      ((b.b)localObject1).jFo.setTag(Integer.valueOf(paramInt));
      label789:
      ((b.b)localObject1).jFo.setOnClickListener(this.jFd);
      label915:
      ((b.b)localObject1).jFp.setTag(Integer.valueOf(paramInt));
      ((b.b)localObject1).jFp.setOnClickListener(this.jFd);
      return localObject2;
      ((b.b)localObject1).jFk.setVisibility(8);
      break;
      label1058:
      ((b.b)localObject1).ifC.setBackgroundColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_info_bg));
      break label687;
      label1082:
      ((b.b)localObject1).jFn.setVisibility(0);
      break label705;
      label1094:
      ((b.b)localObject1).jwp.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.f.ExdeviceRankNumberFontSize));
      break label738;
      label1120:
      ((b.b)localObject1).jwp.setText(locald.field_ranknum);
      break label757;
      label1149:
      ((b.b)localObject1).jFl.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_step));
      break label789;
      label1173:
      ((b.b)localObject1).jFj.setText(j.a(this.mContext, r.gV(locald.field_username), ((b.b)localObject1).jFj.getTextSize()));
      break label915;
      label1207:
      ((b.b)localObject1).jFm.setSelfLikeState(0);
      break label952;
      label1219:
      ((b.b)localObject1).jFm.setSelfLikeState(locald.field_selfLikeState);
      break label952;
      label1235:
      ((b.b)localObject1).jFm.setClickable(false);
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
  
  public final e qz(int paramInt)
  {
    return (e)this.jEW.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */