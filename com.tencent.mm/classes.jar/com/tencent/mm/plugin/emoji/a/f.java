package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.g.c;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG;
  public boolean xGK;
  public boolean xGL;
  public boolean xGM;
  public boolean xGN;
  private List<String> xGO;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(179051);
    this.TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    this.xGK = false;
    this.xGL = true;
    this.xGM = false;
    this.xGN = true;
    this.xGO = new LinkedList();
    AppMethodBeat.o(179051);
  }
  
  public void JZ(int paramInt) {}
  
  public void Ka(int paramInt) {}
  
  public void Kb(int paramInt) {}
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(108325);
    a locala = (a)paramView.getTag();
    paramViewGroup = Kd(paramInt);
    if (this.xGM)
    {
      paramViewGroup.xHL = true;
      paramViewGroup.xHJ = false;
      paramViewGroup.xHK = false;
    }
    Object localObject;
    label138:
    boolean bool;
    label200:
    View localView;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.xHK = this.xGN;
      localObject = paramViewGroup.xHF;
      if (localObject != null) {
        break label301;
      }
      locala.JY(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        localObject = paramViewGroup.xHE;
        if (localObject != null)
        {
          locala.setTitle(((cjb)localObject).Zul);
          if (!c.i((cjb)localObject)) {
            break label424;
          }
          r.bKe().loadImage("", locala.dxW());
          locala.JV(h.d.icon_002_cover);
          bool = com.tencent.mm.plugin.emoji.a.a.e.f((cjb)localObject);
          if (TextUtils.isEmpty(((cjb)localObject).akkB)) {
            break label456;
          }
          locala.dxX().setImageDrawable(null);
          locala.dxX().setVisibility(0);
          r.bKe().a(((cjb)localObject).akkB, locala.dxX(), com.tencent.mm.plugin.emoji.mgr.e.gJ("", ((cjb)localObject).akkB));
          localView = locala.xGc;
          if (!this.xGO.contains(((cjb)localObject).ProductID)) {
            break label488;
          }
        }
      }
    }
    label301:
    label456:
    label488:
    for (paramInt = i;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      if ((paramViewGroup.xHG == null) || (!com.tencent.mm.plugin.emoji.a.a.e.gO(paramViewGroup.xHG.akke, 128))) {
        break label494;
      }
      locala.anL(paramViewGroup.xHG.akkt);
      if ((this.xGK) && (locala.xFZ != null)) {
        locala.xFZ.setBackgroundResource(h.d.comm_list_item_selector_no_divider);
      }
      AppMethodBeat.o(108325);
      return paramView;
      locala.setTitle(((anj)localObject).hAP);
      locala.anK(((anj)localObject).IGG);
      if (!Util.isNullOrNil(((anj)localObject).IHo)) {
        r.bKe().a(((anj)localObject).IHo, locala.dxW(), com.tencent.mm.plugin.emoji.mgr.e.gJ("", ((anj)localObject).IHo));
      }
      if (!Util.isNullOrNil(((anj)localObject).akjW))
      {
        r.bKe().a(((anj)localObject).akjW, locala.dxX(), com.tencent.mm.plugin.emoji.mgr.e.gJ("", ((anj)localObject).akjW));
        locala.JW(0);
      }
      for (;;)
      {
        locala.JY(8);
        paramInt = j;
        break;
        locala.JW(8);
      }
      r.bKe().a(((cjb)localObject).IHo, locala.dxW(), com.tencent.mm.plugin.emoji.mgr.e.gJ(((cjb)localObject).ProductID, ((cjb)localObject).IHo));
      break label138;
      if (bool)
      {
        locala.JW(0);
        locala.JX(h.d.emotionstore_newtips);
        break label200;
      }
      locala.JW(8);
      break label200;
    }
    label424:
    label494:
    if (!Util.isNullOrNil(((cjb)localObject).akkC)) {}
    for (paramViewGroup = ((cjb)localObject).akkC;; paramViewGroup = ((cjb)localObject).akkA)
    {
      locala.anK(paramViewGroup);
      break;
    }
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
    paramContext.a(this.xHs);
    AppMethodBeat.o(108323);
    return paramContext;
  }
  
  public int dyh()
  {
    return 0;
  }
  
  public int dyi()
  {
    return 0;
  }
  
  public int dyj()
  {
    return 0;
  }
  
  public final void fa(List<String> paramList)
  {
    AppMethodBeat.i(179052);
    this.xGO.clear();
    if (paramList != null) {
      this.xGO.addAll(paramList);
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
    
    protected final void dxT()
    {
      AppMethodBeat.i(108319);
      this.xGb.setVisibility(8);
      dxY();
      this.xGi.setVisibility(8);
      this.xGm.setVisibility(8);
      this.xGn.setVisibility(8);
      this.xGa.setVisibility(0);
      this.sUt.setVisibility(0);
      this.xGk.setVisibility(0);
      this.xGj.setVisibility(0);
      this.xGl.setVisibility(0);
      AppMethodBeat.o(108319);
    }
    
    protected final int[] dxU()
    {
      AppMethodBeat.i(108320);
      int i = com.tencent.mm.cd.a.br(getContext(), h.c.emoji_item_store_image_size);
      AppMethodBeat.o(108320);
      return new int[] { i, i };
    }
    
    protected final int dxV()
    {
      AppMethodBeat.i(108321);
      int i = com.tencent.mm.cd.a.br(getContext(), h.c.emoji_item_store_height);
      AppMethodBeat.o(108321);
      return i;
    }
    
    protected final boolean dyb()
    {
      AppMethodBeat.i(108322);
      boolean bool = f.a(f.this);
      AppMethodBeat.o(108322);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */