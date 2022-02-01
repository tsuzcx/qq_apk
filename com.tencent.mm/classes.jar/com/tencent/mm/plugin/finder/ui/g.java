package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.feed.k.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public final class g
  extends k.a
{
  String TAG;
  
  public g(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
  {
    super(paramInt, paramMMActivity, paramBoolean, false, 8);
    AppMethodBeat.i(275622);
    this.TAG = "Finder.FinderShareFeedDetailUI";
    AppMethodBeat.o(275622);
  }
  
  public final com.tencent.mm.view.recyclerview.f dsu()
  {
    AppMethodBeat.i(167708);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(167708);
    return localf;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(167707);
      switch (paramInt)
      {
      case 3: 
      default: 
        localObject = aj.AGc;
        aj.em(this.AwY.TAG, paramInt);
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(167707);
        return localObject;
      case 4: 
        if (this.AwY.dsq())
        {
          localObject = (e)new u(this.AwY.xkW, (i)this.AwY, false, 0, 12);
          AppMethodBeat.o(167707);
          return localObject;
        }
        localObject = (e)new am(this.AwY.xkW, (i)this.AwY, false, 0, 12);
        AppMethodBeat.o(167707);
        return localObject;
      }
      if (this.AwY.dsq())
      {
        localObject = (e)new r((i)this.AwY, false, 0, 6);
        AppMethodBeat.o(167707);
        return localObject;
      }
      Object localObject = (e)new v((i)this.AwY, false, 0, 6);
      AppMethodBeat.o(167707);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.g
 * JD-Core Version:    0.7.0.1
 */