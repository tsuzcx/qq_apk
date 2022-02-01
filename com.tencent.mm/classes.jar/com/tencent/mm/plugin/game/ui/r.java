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
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.c;
import com.tencent.mm.plugin.game.h.d;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  int IFh;
  int IRT;
  boolean IUl;
  int IUm;
  int IUn;
  int IUo;
  int IUp;
  private int IUq;
  boolean IUr;
  boolean IUs;
  private ArrayList<d> IUt;
  Context context;
  boolean hAE;
  ArrayList<b> mfy;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(42373);
    this.hAE = false;
    this.IUl = false;
    this.IRT = 0;
    this.IUm = 0;
    this.IUn = 0;
    this.IUo = 0;
    this.IUp = 0;
    this.IFh = 0;
    this.IUr = false;
    this.IUs = false;
    this.context = paramContext;
    this.mfy = null;
    this.IUq = paramContext.getResources().getColor(h.b.HST);
    AppMethodBeat.o(42373);
  }
  
  private String aHf(String paramString)
  {
    AppMethodBeat.i(42378);
    if (this.IUt == null) {
      this.IUt = new ArrayList();
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
        this.IUt.add(locald);
      }
      this.IUt.clear();
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
      paramString = new SpannableString(aHf(paramString));
      Iterator localIterator = this.IUt.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.IUq), locald.start, locald.end, 33);
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
    if (this.mfy == null)
    {
      AppMethodBeat.o(42374);
      return 0;
    }
    int i = this.mfy.size();
    AppMethodBeat.o(42374);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(42375);
    Object localObject = this.mfy.get(paramInt);
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
        ((a)localObject1).contentView = ((View)localObject2).findViewById(h.e.HVJ);
        ((a)localObject1).dyS = ((ImageView)((View)localObject2).findViewById(h.e.HVM));
        ((a)localObject1).ukP = ((TextView)((View)localObject2).findViewById(h.e.HVN));
        ((a)localObject1).IUx = ((TextView)((View)localObject2).findViewById(h.e.HVH));
        ((a)localObject1).FcR = ((TextView)((View)localObject2).findViewById(h.e.HVK));
        ((a)localObject1).IUy = ((TextView)((View)localObject2).findViewById(h.e.HVO));
        ((a)localObject1).IUz = ((View)localObject2).findViewById(h.e.HVL);
        ((a)localObject1).IUA = ((TextView)((View)localObject2).findViewById(h.e.HXQ));
        ((a)localObject1).IUB = ((TextView)((View)localObject2).findViewById(h.e.HTK));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((a)localObject1).ukP != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((a)localObject1).FcR != null)
          {
            paramView = ((a)localObject1).ukP;
            paramViewGroup = ((a)localObject1).FcR;
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
      paramInt = h.f.Iah;
      break;
      paramInt = h.f.Iao;
      break;
      paramInt = h.f.Ian;
      break;
      paramInt = h.f.Iaj;
      break;
      paramInt = h.f.Iak;
      break;
      paramInt = h.f.Iam;
      break;
      paramViewGroup = (a)paramView.getTag();
      break label298;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).oKn = false;
        ((e.a.a)localObject1).oKp = false;
        e.fIb().a(paramViewGroup.dyS, localb.iconUrl, ((e.a.a)localObject1).fIc());
      }
      e(paramViewGroup.ukP, localb.name);
      e(paramViewGroup.IUx, localb.brief);
      e(paramViewGroup.FcR, localb.remark);
      break label344;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).oKn = false;
        ((e.a.a)localObject1).oKp = false;
        ((e.a.a)localObject1).IYr = true;
        e.fIb().a(paramViewGroup.dyS, localb.iconUrl, ((e.a.a)localObject1).fIc());
        paramViewGroup.dyS.setVisibility(0);
        label608:
        e(paramViewGroup.ukP, localb.name);
        e(paramViewGroup.FcR, localb.remark);
        if (Util.isNullOrNil(localb.sourceName)) {
          break label728;
        }
        paramViewGroup.IUA.setText(p.b(this.context, localb.sourceName));
        paramViewGroup.IUA.setVisibility(0);
      }
      for (;;)
      {
        if (localb.createTime <= 0L) {
          break label740;
        }
        paramViewGroup.IUB.setText(b.r(this.context, localb.createTime * 1000L));
        paramViewGroup.IUB.setVisibility(0);
        break;
        paramViewGroup.dyS.setVisibility(8);
        break label608;
        label728:
        paramViewGroup.IUA.setVisibility(8);
      }
      label740:
      paramViewGroup.IUB.setVisibility(8);
      break label344;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).oKn = false;
        ((e.a.a)localObject1).oKp = false;
        e.fIb().a(paramViewGroup.dyS, localb.iconUrl, ((e.a.a)localObject1).fIc());
      }
      e(paramViewGroup.ukP, localb.name);
      e(paramViewGroup.IUx, localb.brief);
      e(paramViewGroup.FcR, localb.remark);
      localObject1 = paramViewGroup.IUy;
      localObject2 = localb.IUE;
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
      paramViewGroup.FcR.setText(localb.name);
      break label344;
      paramViewGroup.dyS.setImageResource(h.h.search_more_button_icon);
      paramViewGroup.ukP.setText(localb.name);
      break label344;
      if (localb.IUI) {
        paramViewGroup.contentView.setBackgroundResource(h.d.comm_list_item_selector_no_divider);
      }
      for (;;)
      {
        paramInt = this.context.getResources().getDimensionPixelSize(h.c.HTl);
        paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
        break;
        paramViewGroup.contentView.setBackgroundResource(h.d.comm_list_item_selector);
      }
      if (localb.IUH) {
        paramViewGroup.IUz.setVisibility(8);
      } else {
        paramViewGroup.IUz.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void reset()
  {
    this.IFh = 0;
    this.IUr = false;
  }
  
  static final class a
  {
    TextView FcR;
    TextView IUA;
    TextView IUB;
    TextView IUx;
    TextView IUy;
    View IUz;
    public View contentView;
    ImageView dyS;
    TextView ukP;
  }
  
  public static final class b
  {
    public cbl IUC;
    public String IUD;
    public LinkedList<String> IUE;
    public int IUF;
    public int IUG;
    public boolean IUH = false;
    public boolean IUI = false;
    public r.c IUJ;
    public int actionType;
    public String appId;
    public String brief;
    public long createTime;
    public String hAB;
    public String iconUrl;
    public String name;
    public String remark;
    public String sourceName;
    public int type;
    
    public static b a(cbk paramcbk)
    {
      AppMethodBeat.i(42371);
      b localb = new b();
      localb.type = 2;
      localb.name = paramcbk.hAP;
      localb.remark = paramcbk.IGG;
      localb.iconUrl = paramcbk.ThumbUrl;
      localb.IUD = paramcbk.aako;
      localb.IUF = paramcbk.aakI;
      localb.IUG = paramcbk.aakJ;
      localb.appId = paramcbk.oOI;
      localb.sourceName = paramcbk.IKJ;
      localb.createTime = paramcbk.HTK;
      localb.IUJ = new r.c(paramcbk.aako, (byte)0);
      AppMethodBeat.o(42371);
      return localb;
    }
    
    public static b cd(int paramInt, String paramString)
    {
      AppMethodBeat.i(42370);
      b localb = new b();
      localb.type = paramInt;
      localb.name = paramString;
      localb.IUJ = new r.c();
      AppMethodBeat.o(42370);
      return localb;
    }
  }
  
  public static final class c
  {
    int IUF;
    int IUG;
    String IUK;
    public int actionType;
    String appId;
    String h5Url;
    int hYi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r
 * JD-Core Version:    0.7.0.1
 */