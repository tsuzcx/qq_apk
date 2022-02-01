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
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.e.e.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.bgm;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  Context context;
  boolean dDz;
  ArrayList<b> gUV;
  int xGW;
  int xTs;
  boolean xVK;
  int xVL;
  int xVM;
  int xVN;
  int xVO;
  private int xVP;
  boolean xVQ;
  boolean xVR;
  private ArrayList<d> xVS;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(42373);
    this.dDz = false;
    this.xVK = false;
    this.xTs = 0;
    this.xVL = 0;
    this.xVM = 0;
    this.xVN = 0;
    this.xVO = 0;
    this.xGW = 0;
    this.xVQ = false;
    this.xVR = false;
    this.context = paramContext;
    this.gUV = null;
    this.xVP = paramContext.getResources().getColor(2131100554);
    AppMethodBeat.o(42373);
  }
  
  private String aAD(String paramString)
  {
    AppMethodBeat.i(42378);
    if (this.xVS == null) {
      this.xVS = new ArrayList();
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
        this.xVS.add(locald);
      }
      this.xVS.clear();
    }
    paramString = paramString.toString();
    AppMethodBeat.o(42378);
    return paramString;
  }
  
  private void d(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42379);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = new SpannableString(aAD(paramString));
      Iterator localIterator = this.xVS.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.xVP), locald.start, locald.end, 33);
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
    if (this.gUV == null)
    {
      AppMethodBeat.o(42374);
      return 0;
    }
    int i = this.gUV.size();
    AppMethodBeat.o(42374);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(42375);
    Object localObject = this.gUV.get(paramInt);
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
        ((a)localObject1).contentView = ((View)localObject2).findViewById(2131301999);
        ((a)localObject1).vs = ((ImageView)((View)localObject2).findViewById(2131302002));
        ((a)localObject1).xVW = ((TextView)((View)localObject2).findViewById(2131302004));
        ((a)localObject1).xVX = ((TextView)((View)localObject2).findViewById(2131301997));
        ((a)localObject1).xVY = ((TextView)((View)localObject2).findViewById(2131302000));
        ((a)localObject1).xVZ = ((TextView)((View)localObject2).findViewById(2131302005));
        ((a)localObject1).xWa = ((View)localObject2).findViewById(2131302001);
        ((a)localObject1).xWb = ((TextView)((View)localObject2).findViewById(2131308310));
        ((a)localObject1).xWc = ((TextView)((View)localObject2).findViewById(2131299325));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((a)localObject1).xVW != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((a)localObject1).xVY != null)
          {
            paramView = ((a)localObject1).xVW;
            paramViewGroup = ((a)localObject1).xVY;
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
        label291:
        switch (localb.type)
        {
        case 4: 
        default: 
          label340:
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
      paramInt = 2131494943;
      break;
      paramInt = 2131494950;
      break;
      paramInt = 2131494949;
      break;
      paramInt = 2131494945;
      break;
      paramInt = 2131494946;
      break;
      paramInt = 2131494948;
      break;
      paramViewGroup = (a)paramView.getTag();
      break label291;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).jbd = false;
        ((e.a.a)localObject1).jbf = false;
        e.dWR().a(paramViewGroup.vs, localb.iconUrl, ((e.a.a)localObject1).dWS());
      }
      d(paramViewGroup.xVW, localb.name);
      d(paramViewGroup.xVX, localb.xWd);
      d(paramViewGroup.xVY, localb.remark);
      break label340;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).jbd = false;
        ((e.a.a)localObject1).jbf = false;
        ((e.a.a)localObject1).xZt = true;
        e.dWR().a(paramViewGroup.vs, localb.iconUrl, ((e.a.a)localObject1).dWS());
        paramViewGroup.vs.setVisibility(0);
        label604:
        d(paramViewGroup.xVW, localb.name);
        d(paramViewGroup.xVY, localb.remark);
        if (Util.isNullOrNil(localb.iFo)) {
          break label724;
        }
        paramViewGroup.xWb.setText(l.c(this.context, localb.iFo));
        paramViewGroup.xWb.setVisibility(0);
      }
      for (;;)
      {
        if (localb.createTime <= 0L) {
          break label736;
        }
        paramViewGroup.xWc.setText(b.n(this.context, localb.createTime * 1000L));
        paramViewGroup.xWc.setVisibility(0);
        break;
        paramViewGroup.vs.setVisibility(8);
        break label604;
        label724:
        paramViewGroup.xWb.setVisibility(8);
      }
      label736:
      paramViewGroup.xWc.setVisibility(8);
      break label340;
      if (!Util.isNullOrNil(localb.iconUrl))
      {
        localObject1 = new e.a.a();
        ((e.a.a)localObject1).jbd = false;
        ((e.a.a)localObject1).jbf = false;
        e.dWR().a(paramViewGroup.vs, localb.iconUrl, ((e.a.a)localObject1).dWS());
      }
      d(paramViewGroup.xVW, localb.name);
      d(paramViewGroup.xVX, localb.xWd);
      d(paramViewGroup.xVY, localb.remark);
      localObject1 = paramViewGroup.xVZ;
      localObject2 = localb.xWg;
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
        break label340;
      }
      ((TextView)localObject1).setVisibility(8);
      break label340;
      paramViewGroup.xVY.setText(localb.name);
      break label340;
      paramViewGroup.vs.setImageResource(2131691448);
      paramViewGroup.xVW.setText(localb.name);
      break label340;
      if (localb.xWk) {
        paramViewGroup.contentView.setBackgroundResource(2131231901);
      }
      for (;;)
      {
        paramInt = this.context.getResources().getDimensionPixelSize(2131165571);
        paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
        break;
        paramViewGroup.contentView.setBackgroundResource(2131231898);
      }
      if (localb.xWj) {
        paramViewGroup.xWa.setVisibility(8);
      } else {
        paramViewGroup.xWa.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final void reset()
  {
    this.xGW = 0;
    this.xVQ = false;
  }
  
  static final class a
  {
    public View contentView;
    ImageView vs;
    TextView xVW;
    TextView xVX;
    TextView xVY;
    TextView xVZ;
    View xWa;
    TextView xWb;
    TextView xWc;
  }
  
  public static final class b
  {
    public int actionType;
    public String appId;
    public long createTime;
    public String dDv;
    public String iFo;
    public String iconUrl;
    public String name;
    public String remark;
    public int type;
    public String xWd;
    public bgm xWe;
    public String xWf;
    public LinkedList<String> xWg;
    public int xWh;
    public int xWi;
    public boolean xWj = false;
    public boolean xWk = false;
    public r.c xWl;
    
    public static b a(bgl parambgl)
    {
      AppMethodBeat.i(42371);
      b localb = new b();
      localb.type = 2;
      localb.name = parambgl.Title;
      localb.remark = parambgl.Desc;
      localb.iconUrl = parambgl.ThumbUrl;
      localb.xWf = parambgl.LPS;
      localb.xWh = parambgl.LQm;
      localb.xWi = parambgl.LQn;
      localb.appId = parambgl.jfi;
      localb.iFo = parambgl.xMq;
      localb.createTime = parambgl.Gaz;
      localb.xWl = new r.c(parambgl.LPS, (byte)0);
      AppMethodBeat.o(42371);
      return localb;
    }
    
    public static b bA(int paramInt, String paramString)
    {
      AppMethodBeat.i(42370);
      b localb = new b();
      localb.type = paramInt;
      localb.name = paramString;
      localb.xWl = new r.c();
      AppMethodBeat.o(42370);
      return localb;
    }
  }
  
  public static final class c
  {
    public int actionType;
    String appId;
    int dYu;
    String h5Url;
    int position;
    int type;
    int xWh;
    int xWi;
    String xWm;
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r
 * JD-Core Version:    0.7.0.1
 */