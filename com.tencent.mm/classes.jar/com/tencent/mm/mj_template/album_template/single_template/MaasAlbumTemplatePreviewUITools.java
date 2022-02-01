package com.tencent.mm.mj_template.album_template.single_template;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mj_template.plugin.c.e;
import com.tencent.mm.ui.MMComposeActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.pulldown.c;
import kotlin.Metadata;

@a(3)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/single_template/MaasAlbumTemplatePreviewUITools;", "Lcom/tencent/mm/ui/MMComposeActivity;", "()V", "getLayoutId", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MaasAlbumTemplatePreviewUITools
  extends MMComposeActivity
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return c.e.ocT;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.single_template.MaasAlbumTemplatePreviewUITools
 * JD-Core Version:    0.7.0.1
 */