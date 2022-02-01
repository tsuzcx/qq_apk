package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG;
  public boolean uAh;
  public boolean uAi;
  public boolean uAj;
  public boolean uAk;
  private List<String> uAl;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(179051);
    this.TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    this.uAh = false;
    this.uAi = true;
    this.uAj = false;
    this.uAk = true;
    this.uAl = new LinkedList();
    AppMethodBeat.o(179051);
  }
  
  public void Js(int paramInt) {}
  
  public void Jt(int paramInt) {}
  
  public void Ju(int paramInt) {}
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(108325);
    a locala = (a)paramView.getTag();
    paramViewGroup = Jv(paramInt);
    if (this.uAj)
    {
      paramViewGroup.uBg = true;
      paramViewGroup.uBe = false;
      paramViewGroup.uBf = false;
    }
    Object localObject;
    label134:
    boolean bool;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.uBf = this.uAk;
      localObject = paramViewGroup.uBb;
      if (localObject != null) {
        break label282;
      }
      locala.Jr(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        paramViewGroup = paramViewGroup.uBa;
        if (paramViewGroup != null)
        {
          locala.setTitle(paramViewGroup.Suv);
          if (!com.tencent.mm.plugin.emoji.i.a.g(paramViewGroup)) {
            break label405;
          }
          q.bml().loadImage("", locala.cTB());
          locala.Jo(i.d.icon_002_cover);
          bool = com.tencent.mm.plugin.emoji.a.a.e.fX(paramViewGroup.Tey, 2);
          if (TextUtils.isEmpty(paramViewGroup.VHQ)) {
            break label434;
          }
          locala.cTC().setImageDrawable(null);
          locala.cTC().setVisibility(0);
          q.bml().a(paramViewGroup.VHQ, locala.cTC(), com.tencent.mm.plugin.emoji.e.e.gd("", paramViewGroup.VHQ));
          label196:
          localObject = locala.uzC;
          if (!this.uAl.contains(paramViewGroup.ProductID)) {
            break label466;
          }
          paramInt = i;
          label222:
          ((View)localObject).setVisibility(paramInt);
          if (Util.isNullOrNil(paramViewGroup.VHR)) {
            break label472;
          }
        }
      }
    }
    label282:
    label434:
    label466:
    label472:
    for (paramViewGroup = paramViewGroup.VHR;; paramViewGroup = paramViewGroup.VHP)
    {
      locala.atT(paramViewGroup);
      if ((this.uAh) && (locala.uzz != null)) {
        locala.uzz.setBackgroundResource(i.d.comm_list_item_selector_no_divider);
      }
      AppMethodBeat.o(108325);
      return paramView;
      locala.setTitle(((ajw)localObject).fwr);
      locala.atT(((ajw)localObject).CMB);
      if (!Util.isNullOrNil(((ajw)localObject).CNj)) {
        q.bml().a(((ajw)localObject).CNj, locala.cTB(), com.tencent.mm.plugin.emoji.e.e.gd("", ((ajw)localObject).CNj));
      }
      if (!Util.isNullOrNil(((ajw)localObject).Ter))
      {
        q.bml().a(((ajw)localObject).Ter, locala.cTC(), com.tencent.mm.plugin.emoji.e.e.gd("", ((ajw)localObject).Ter));
        locala.Jp(0);
      }
      for (;;)
      {
        locala.Jr(8);
        paramInt = j;
        break;
        locala.Jp(8);
      }
      q.bml().a(paramViewGroup.CNj, locala.cTB(), com.tencent.mm.plugin.emoji.e.e.gd(paramViewGroup.ProductID, paramViewGroup.CNj));
      break label134;
      if (bool)
      {
        locala.Jp(0);
        locala.Jq(i.d.emotionstore_newtips);
        break label196;
      }
      locala.Jp(8);
      break label196;
      paramInt = 8;
      break label222;
    }
  }
  
  public int cTM()
  {
    return 0;
  }
  
  public int cTN()
  {
    return 0;
  }
  
  public int cTO()
  {
    return 0;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108324);
    super.clear();
    AppMethodBeat.o(108324);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108323);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.uAP);
    AppMethodBeat.o(108323);
    return paramContext;
  }
  
  public final void de(List<String> paramList)
  {
    AppMethodBeat.i(179052);
    this.uAl.clear();
    if (paramList != null) {
      this.uAl.addAll(paramList);
    }
    AppMethodBeat.o(179052);
  }
  
  public final class a
    extends a
  {
    public a(Context paramContext, View paramView)
    {
      super(paramView);
    }
    
    protected final int cTA()
    {
      AppMethodBeat.i(108321);
      int i = com.tencent.mm.ci.a.aY(getContext(), i.c.emoji_item_store_height);
      AppMethodBeat.o(108321);
      return i;
    }
    
    protected final boolean cTG()
    {
      AppMethodBeat.i(108322);
      boolean bool = f.a(f.this);
      AppMethodBeat.o(108322);
      return bool;
    }
    
    protected final void cTy()
    {
      AppMethodBeat.i(108319);
      this.uzB.setVisibility(8);
      cTD();
      this.uzF.setVisibility(8);
      this.uzJ.setVisibility(8);
      this.uzK.setVisibility(8);
      this.uzA.setVisibility(0);
      this.pPT.setVisibility(0);
      this.uzH.setVisibility(0);
      this.uzG.setVisibility(0);
      this.uzI.setVisibility(0);
      AppMethodBeat.o(108319);
    }
    
    protected final int[] cTz()
    {
      AppMethodBeat.i(108320);
      int i = com.tencent.mm.ci.a.aY(getContext(), i.c.emoji_item_store_image_size);
      AppMethodBeat.o(108320);
      return new int[] { i, i };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */