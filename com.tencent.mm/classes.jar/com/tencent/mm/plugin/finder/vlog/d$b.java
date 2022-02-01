package com.tencent.mm.plugin.finder.vlog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.view.e;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/vlog/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "", "editor", "Lcom/tencent/mm/api/MMPhotoEditor;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "(Lcom/tencent/mm/api/MMPhotoEditor;Lcom/tencent/mm/view/PhotoDrawingView;)V", "getDrawingView", "()Lcom/tencent/mm/view/PhotoDrawingView;", "getEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
final class d$b
{
  final e sgn;
  final y sgu;
  
  public d$b(y paramy, e parame)
  {
    AppMethodBeat.i(204783);
    this.sgu = paramy;
    this.sgn = parame;
    AppMethodBeat.o(204783);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204786);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!k.g(this.sgu, paramObject.sgu)) || (!k.g(this.sgn, paramObject.sgn))) {}
      }
    }
    else
    {
      AppMethodBeat.o(204786);
      return true;
    }
    AppMethodBeat.o(204786);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(204785);
    Object localObject = this.sgu;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.sgn;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(204785);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204784);
    String str = "PhotoEditorViewData(editor=" + this.sgu + ", drawingView=" + this.sgn + ")";
    AppMethodBeat.o(204784);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.vlog.d.b
 * JD-Core Version:    0.7.0.1
 */