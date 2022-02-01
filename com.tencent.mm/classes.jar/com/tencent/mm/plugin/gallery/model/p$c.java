package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "", "(Ljava/lang/String;I)V", "IDLE", "UP", "DOWN", "plugin-gallery_release"})
public enum p$c
{
  static
  {
    AppMethodBeat.i(111791);
    c localc1 = new c("IDLE", 0);
    sKK = localc1;
    c localc2 = new c("UP", 1);
    sKL = localc2;
    c localc3 = new c("DOWN", 2);
    sKM = localc3;
    sKN = new c[] { localc1, localc2, localc3 };
    AppMethodBeat.o(111791);
  }
  
  private p$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.p.c
 * JD-Core Version:    0.7.0.1
 */