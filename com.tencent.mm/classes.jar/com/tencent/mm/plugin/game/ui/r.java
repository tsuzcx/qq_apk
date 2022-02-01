package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  int CKZ;
  int CXD;
  boolean CZV;
  int CZW;
  int CZX;
  int CZY;
  int CZZ;
  private int Daa;
  boolean Dab;
  boolean Dac;
  private ArrayList<d> Dad;
  Context context;
  boolean fwi;
  ArrayList<b> jFL;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(42373);
    this.fwi = false;
    this.CZV = false;
    this.CXD = 0;
    this.CZW = 0;
    this.CZX = 0;
    this.CZY = 0;
    this.CZZ = 0;
    this.CKZ = 0;
    this.Dab = false;
    this.Dac = false;
    this.context = paramContext;
    this.jFL = null;
    this.Daa = paramContext.getResources().getColor(g.b.CgK);
    AppMethodBeat.o(42373);
  }
  
  private String aKp(String paramString)
  {
    AppMethodBeat.i(42378);
    if (this.Dad == null) {
      this.Dad = new ArrayList();
    }
    for (;;)
    {
      paramString = new StringBuilder(paramString);
      d locald = new d((byte)0);
      for (int i = paramString.indexOf("<em>"); i >= 0; i = paramString.indexOf("<em>"))
      {
        locald.start = i;
        paramString.delete(i, i + 4);
        i = paramString.indexOf("</em>");
        if (i < 0) {
          break;
        }
        locald.end = i;
        paramString.delete(i, i + 5);
        this.Dad.add(locald);
      }
      this.Dad.clear();
    }
    paramString = paramString.toString();
    AppMethodBeat.o(42378);
    return paramString;
  }
  
  private void e(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42379);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = new SpannableString(aKp(paramString));
      Iterator localIterator = this.Dad.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.Daa), locald.start, locald.end, 33);
        }
      }
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      AppMethodBeat.o(42379);
      return;
    }
    paramTextView.setVisibility(8);
    AppMethodBeat.o(42379);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42374);
    if (this.jFL == null)
    {
      AppMethodBeat.o(42374);
      return 0;
    }
    int i = this.jFL.size();
    AppMethodBeat.o(42374);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(42375);
    Object localObject = this.jFL.get(paramInt);
    AppMethodBeat.o(42375);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(42376);
    paramInt = ((b)getItem(paramInt)).type;
    AppMethodBeat.o(42376);
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42377);
    b localb = (b)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new a((byte)0);
      paramView = this.context;
      switch (localb.type)
      {
      case 4: 
      default: 
        paramInt = 0;
        localObject2 = View.inflate(paramView, paramInt, null);
        ((a)localObject1).contentView = ((View)localObject2).findViewById(g.e.CjB);
        ((a)localObject1).bFS = ((ImageView)((View)localObject2).findViewById(g.e.CjE));
        ((a)localObject1).Dah = ((TextView)((View)localObject2).findViewById(g.e.CjF));
        ((a)localObject1).Dai = ((TextView)((View)localObject2).findViewById(g.e.Cjz));
        ((a)localObject1).zQG = ((TextView)((View)localObject2).findViewById(g.e.CjC));
        ((a)localObject1).Daj = ((TextView)((View)localObject2).findViewById(g.e.CjG));
        ((a)localObject1).Dak = ((View)localObject2).findViewById(g.e.CjD);
        ((a)localObject1).Dal = ((TextView)((View)localObject2).findViewById(g.e.ClI));
        ((a)localObject1).Dam = ((TextView)((View)localObject2).findViewById(g.e.ChC));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((a)localObject1).Dah != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((a)localObject1).zQG != null)
          {
            paramView = ((a)localObject1).Dah;
            paramViewGroup = ((a)localObject1).zQG;
            paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
              public final void onGlobalLayout()
              {
                AppMethodBeat.i(42369);
                if (paramView.getLineCount() > 1)
                {
                  paramView.setMaxLines(2);
                  paramViewGroup.setMaxLines(1);
                  AppMethodBeat.o(42369);
                  return;
                }
                paramViewGroup.setMaxLines(2);
                AppMethodBeat.o(42369);
              }
            });
            paramView = (View)localObject2;
            paramViewGroup = (ViewGroup)localObject1;
          }
        }
        label298:
        switch (localb.type)
        {
        case 4: 
        default: 
          label344:
          switch (localb.type)
          {
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(42377);
      return paramView;
      paramInt = g.f.CnZ;
      break;
      paramInt = g.f.Cog;
      break;
      paramInt = g.f.Cof;
      break;
      paramInt = g.f.Cob;
      break;
      paramInt = g.f.Coc;
      break;
      paramInt = g.f.Coe;
      break;
      paramViewGroup = (a)paramView.getTag();
      break label298;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).lRB = false;
        ((e.a.a)localObject1).lRD = false;
        e.eAa().a(paramViewGroup.bFS, localb.iconUrl, ((e.a.a)localObject1).eAb());
      }
      e(paramViewGroup.Dah, localb.name);
      e(paramViewGroup.Dai, localb.Dan);
      e(paramViewGroup.zQG, localb.remark);
      break label344;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).lRB = false;
        ((e.a.a)localObject1).lRD = false;
        ((e.a.a)localObject1).Dea = true;
        e.eAa().a(paramViewGroup.bFS, localb.iconUrl, ((e.a.a)localObject1).eAb());
        paramViewGroup.bFS.setVisibility(0);
        label608:
        e(paramViewGroup.Dah, localb.name);
        e(paramViewGroup.zQG, localb.remark);
        if (Util.isNullOrNil(localb.sourceName)) {
          break label728;
        }
        paramViewGroup.Dal.setText(l.c(this.context, localb.sourceName));
        paramViewGroup.Dal.setVisibility(0);
      }
      for (;;)
      {
        if (localb.createTime <= 0L) {
          break label740;
        }
        paramViewGroup.Dam.setText(b.p(this.context, localb.createTime * 1000L));
        paramViewGroup.Dam.setVisibility(0);
        break;
        paramViewGroup.bFS.setVisibility(8);
        break label608;
        label728:
        paramViewGroup.Dal.setVisibility(8);
      }
      label740:
      paramViewGroup.Dam.setVisibility(8);
      break label344;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).lRB = false;
        ((e.a.a)localObject1).lRD = false;
        e.eAa().a(paramViewGroup.bFS, localb.iconUrl, ((e.a.a)localObject1).eAb());
      }
      e(paramViewGroup.Dah, localb.name);
      e(paramViewGroup.Dai, localb.Dan);
      e(paramViewGroup.zQG, localb.remark);
      localObject1 = paramViewGroup.Daj;
      localObject2 = localb.Daq;
      StringBuilder localStringBuilder = new StringBuilder();
      if (!Util.isNullOrNil((List)localObject2))
      {
        int i = ((LinkedList)localObject2).size();
        paramInt = 0;
        while (paramInt < i - 1)
        {
          localStringBuilder.append((String)((LinkedList)localObject2).get(paramInt) + "\n");
          paramInt += 1;
        }
        localStringBuilder.append((String)((LinkedList)localObject2).get(i - 1));
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(localStringBuilder.toString());
        break label344;
      }
      ((TextView)localObject1).setVisibility(8);
      break label344;
      paramViewGroup.zQG.setText(localb.name);
      break label344;
      paramViewGroup.bFS.setImageResource(g.h.search_more_button_icon);
      paramViewGroup.Dah.setText(localb.name);
      break label344;
      if (localb.Dau) {
        paramViewGroup.contentView.setBackgroundResource(g.d.comm_list_item_selector_no_divider);
      }
      for (;;)
      {
        paramInt = this.context.getResources().getDimensionPixelSize(g.c.Chc);
        paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
        break;
        paramViewGroup.contentView.setBackgroundResource(g.d.comm_list_item_selector);
      }
      if (localb.Dat) {
        paramViewGroup.Dak.setVisibility(8);
      } else {
        paramViewGroup.Dak.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void reset()
  {
    this.CKZ = 0;
    this.Dab = false;
  }
  
  static final class a
  {
    TextView Dah;
    TextView Dai;
    TextView Daj;
    View Dak;
    TextView Dal;
    TextView Dam;
    ImageView bFS;
    public View contentView;
    TextView zQG;
  }
  
  public static final class b
  {
    public String Dan;
    public bno Dao;
    public String Dap;
    public LinkedList<String> Daq;
    public int Dar;
    public int Das;
    public boolean Dat = false;
    public boolean Dau = false;
    public r.c Dav;
    public int actionType;
    public String appId;
    public long createTime;
    public String fwe;
    public String iconUrl;
    public String name;
    public String remark;
    public String sourceName;
    public int type;
    
    public static b a(bnn parambnn)
    {
      AppMethodBeat.i(42371);
      b localb = new b();
      localb.type = 2;
      localb.name = parambnn.fwr;
      localb.remark = parambnn.CMB;
      localb.iconUrl = parambnn.ThumbUrl;
      localb.Dap = parambnn.SYm;
      localb.Dar = parambnn.SYG;
      localb.Das = parambnn.SYH;
      localb.appId = parambnn.lVG;
      localb.sourceName = parambnn.CQz;
      localb.createTime = parambnn.ChC;
      localb.Dav = new r.c(parambnn.SYm, (byte)0);
      AppMethodBeat.o(42371);
      return localb;
    }
    
    public static b bx(int paramInt, String paramString)
    {
      AppMethodBeat.i(42370);
      b localb = new b();
      localb.type = paramInt;
      localb.name = paramString;
      localb.Dav = new r.c();
      AppMethodBeat.o(42370);
      return localb;
    }
  }
  
  public static final class c
  {
    int Dar;
    int Das;
    String Daw;
    public int actionType;
    String appId;
    int fSl;
    String h5Url;
    int position;
    int type;
    
    public c() {}
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      AppMethodBeat.i(42372);
      this.actionType = paramInt1;
      this.type = paramInt2;
      this.appId = paramString1;
      if (paramInt1 == 2) {
        this.h5Url = paramString2;
      }
      AppMethodBeat.o(42372);
    }
    
    public c(String paramString)
    {
      this.actionType = 2;
      this.h5Url = paramString;
    }
    
    public c(String paramString, byte paramByte)
    {
      this.actionType = 2;
      this.type = 3;
      this.h5Url = paramString;
    }
  }
  
  final class d
  {
    int end = -1;
    int start = -1;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r
 * JD-Core Version:    0.7.0.1
 */