package com.tencent.mm.plugin.finder.convert;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.logic.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.recyclerview.e;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "view", "Landroid/view/View;", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "invoke"})
final class h$ag
  extends q
  implements m<View, FinderCommentInfo, z>
{
  h$ag(h paramh, e parame, BaseFinderFeed paramBaseFinderFeed)
  {
    super(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.ag
 * JD-Core Version:    0.7.0.1
 */