package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/ImeResDownloadStatus;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "Success", "CDNFail", "DecryptFail", "CompressFail", "PatchMergeFail", "plugin-hld_release"})
public enum m
{
  final long value;
  
  static
  {
    AppMethodBeat.i(216262);
    m localm1 = new m("Success", 0, 1L);
    DDS = localm1;
    m localm2 = new m("CDNFail", 1, 2L);
    DDT = localm2;
    m localm3 = new m("DecryptFail", 2, 3L);
    DDU = localm3;
    m localm4 = new m("CompressFail", 3, 4L);
    DDV = localm4;
    m localm5 = new m("PatchMergeFail", 4, 5L);
    DDW = localm5;
    DDX = new m[] { localm1, localm2, localm3, localm4, localm5 };
    AppMethodBeat.o(216262);
  }
  
  private m(long paramLong)
  {
    this.value = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.m
 * JD-Core Version:    0.7.0.1
 */