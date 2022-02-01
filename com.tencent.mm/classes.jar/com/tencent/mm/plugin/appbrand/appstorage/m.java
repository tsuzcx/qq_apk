package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m
{
  static
  {
    AppMethodBeat.i(140590);
    nMR = new m("OK", 0);
    nMS = new m("ERR_OP_FAIL", 1);
    nMT = new m("ERR_FS_NOT_MOUNTED", 2);
    nMU = new m("ERR_PARENT_DIR_NOT_EXISTS", 3);
    nMV = new m("ERR_PERMISSION_DENIED", 4);
    nMW = new m("RET_ALREADY_EXISTS", 5);
    nMX = new m("RET_NOT_EXISTS", 6);
    nMY = new m("ERR_DIR_NOT_EMPTY", 7);
    nMZ = new m("ERR_IS_FILE", 8);
    nNa = new m("ERR_IS_DIRECTORY", 9);
    nNb = new m("ERR_SYMLINK", 10);
    nNc = new m("ERR_ILLEGAL_READ_POSITION", 11);
    nNd = new m("ERR_ILLEGAL_READ_LENGTH", 12);
    nNe = new m("ERR_BAD_ZIP_FILE", 13);
    nNf = new m("ERR_WRITE_ZIP_ENTRY", 14);
    nNg = new m("ERR_EXCEED_DIRECTORY_MAX_SIZE", 15);
    nNh = new m("ERR_NOT_SUPPORTED", 16);
    nNi = new m[] { nMR, nMS, nMT, nMU, nMV, nMW, nMX, nMY, nMZ, nNa, nNb, nNc, nNd, nNe, nNf, nNg, nNh };
    AppMethodBeat.o(140590);
  }
  
  private m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.m
 * JD-Core Version:    0.7.0.1
 */