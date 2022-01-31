package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.ttpic.baseutils.SourcePathUtil;

public final class a
{
  public static final String jkh = com.tencent.mm.compatible.util.e.dOQ + "bgcut/";
  
  public static void aJZ()
  {
    com.tencent.mm.vfs.e.nb(jkh);
    if (!com.tencent.mm.vfs.e.bK(jkh + "libsegmentern.so")) {
      com.tencent.mm.vfs.e.r("assets:///bgcut/libsegmentern.so", jkh + "libsegmentern.so");
    }
    if (!com.tencent.mm.vfs.e.bK(jkh + "libsegmentero.so")) {
      com.tencent.mm.vfs.e.r("assets:///bgcut/libsegmentero.so", jkh + "libsegmentero.so");
    }
    SourcePathUtil.setBgCutCpuSoPath(jkh + "libsegmentern.so");
    SourcePathUtil.setBgCutGpuSoPath(jkh + "libsegmentero.so");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a
 * JD-Core Version:    0.7.0.1
 */