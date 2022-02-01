package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum r
{
  static
  {
    AppMethodBeat.i(140590);
    qML = new r("OK", 0);
    qMM = new r("ERR_OP_FAIL", 1);
    qMN = new r("ERR_FS_NOT_MOUNTED", 2);
    qMO = new r("ERR_PARENT_DIR_NOT_EXISTS", 3);
    qMP = new r("ERR_PERMISSION_DENIED", 4);
    qMQ = new r("RET_ALREADY_EXISTS", 5);
    qMR = new r("RET_NOT_EXISTS", 6);
    qMS = new r("ERR_DIR_NOT_EMPTY", 7);
    qMT = new r("ERR_IS_FILE", 8);
    qMU = new r("ERR_IS_DIRECTORY", 9);
    qMV = new r("ERR_SYMLINK", 10);
    qMW = new r("ERR_ILLEGAL_READ_POSITION", 11);
    qMX = new r("ERR_ILLEGAL_READ_LENGTH", 12);
    qMY = new r("ERR_BAD_ZIP_FILE", 13);
    qMZ = new r("ERR_WRITE_ZIP_ENTRY", 14);
    qNa = new r("ERR_EXCEED_DIRECTORY_MAX_SIZE", 15);
    qNb = new r("ERR_NOT_SUPPORTED", 16);
    qNc = new r[] { qML, qMM, qMN, qMO, qMP, qMQ, qMR, qMS, qMT, qMU, qMV, qMW, qMX, qMY, qMZ, qNa, qNb };
    AppMethodBeat.o(140590);
  }
  
  private r() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.r
 * JD-Core Version:    0.7.0.1
 */