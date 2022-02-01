package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/ImeResDownloadStatus;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "Success", "CDNFail", "DecryptFail", "CompressFail", "PatchMergeFail", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum m
{
  final long value;
  
  static
  {
    AppMethodBeat.i(311910);
    JvQ = new m("Success", 0, 1L);
    JvR = new m("CDNFail", 1, 2L);
    JvS = new m("DecryptFail", 2, 3L);
    JvT = new m("CompressFail", 3, 4L);
    JvU = new m("PatchMergeFail", 4, 5L);
    JvV = new m[] { JvQ, JvR, JvS, JvT, JvU };
    AppMethodBeat.o(311910);
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