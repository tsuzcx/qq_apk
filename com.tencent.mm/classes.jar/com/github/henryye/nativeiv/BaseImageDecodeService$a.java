package com.github.henryye.nativeiv;

import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.github.henryye.nativeiv.api.IImageDecodeService.b.a;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.github.henryye.nativeiv.api.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class BaseImageDecodeService$a
  implements IImageDecodeService.b
{
  private BaseImageDecodeService$a(BaseImageDecodeService paramBaseImageDecodeService) {}
  
  public final void a(String paramString, IImageDecodeService.b.a parama, a parama1)
  {
    AppMethodBeat.i(127299);
    Iterator localIterator = new LinkedList(BaseImageDecodeService.access$200(this.aJH)).iterator();
    while (localIterator.hasNext()) {
      ((IImageDecodeService.b)localIterator.next()).a(paramString, parama, parama1);
    }
    AppMethodBeat.o(127299);
  }
  
  public final void a(String paramString, Object paramObject, IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(127300);
    Iterator localIterator = new LinkedList(BaseImageDecodeService.access$200(this.aJH)).iterator();
    while (localIterator.hasNext()) {
      ((IImageDecodeService.b)localIterator.next()).a(paramString, paramObject, paramc, paramImageDecodeConfig);
    }
    AppMethodBeat.o(127300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.github.henryye.nativeiv.BaseImageDecodeService.a
 * JD-Core Version:    0.7.0.1
 */