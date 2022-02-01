package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m
{
  static
  {
    AppMethodBeat.i(140590);
    jPM = new m("OK", 0);
    jPN = new m("ERR_OP_FAIL", 1);
    jPO = new m("ERR_FS_NOT_MOUNTED", 2);
    jPP = new m("ERR_PARENT_DIR_NOT_EXISTS", 3);
    jPQ = new m("ERR_PERMISSION_DENIED", 4);
    jPR = new m("RET_ALREADY_EXISTS", 5);
    jPS = new m("RET_NOT_EXISTS", 6);
    jPT = new m("ERR_DIR_NOT_EMPTY", 7);
    jPU = new m("ERR_IS_FILE", 8);
    jPV = new m("ERR_IS_DIRECTORY", 9);
    jPW = new m("ERR_SYMLINK", 10);
    jPX = new m("ERR_ILLEGAL_READ_POSITION", 11);
    jPY = new m("ERR_ILLEGAL_READ_LENGTH", 12);
    jPZ = new m("ERR_BAD_ZIP_FILE", 13);
    jQa = new m("ERR_WRITE_ZIP_ENTRY", 14);
    jQb = new m("ERR_EXCEED_DIRECTORY_MAX_SIZE", 15);
    jQc = new m("ERR_NOT_SUPPORTED", 16);
    jQd = new m[] { jPM, jPN, jPO, jPP, jPQ, jPR, jPS, jPT, jPU, jPV, jPW, jPX, jPY, jPZ, jQa, jQb, jQc };
    AppMethodBeat.o(140590);
  }
  
  private m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.m
 * JD-Core Version:    0.7.0.1
 */