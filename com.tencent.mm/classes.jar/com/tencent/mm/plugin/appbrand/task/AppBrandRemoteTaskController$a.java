package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AppBrandRemoteTaskController$a
{
  static
  {
    AppMethodBeat.i(132829);
    iKF = new a("NONE", 0);
    iKG = new a("REGISTER", 1);
    iKH = new a("UPDATE", 2);
    iKI = new a("REMOVE", 3);
    iKJ = new a("KILL", 4);
    iKK = new a("KILL_ALL", 5);
    iKL = new a("ASSERT", 6);
    iKM = new a("CHECK_ALIVE", 7);
    iKN = new a("NETWORK_CHANGE", 8);
    iKO = new a("CLEAR_DUPLICATED", 9);
    iKP = new a("PRELOAD", 10);
    iKQ = new a("NOTIFY_PAUSE", 11);
    iKR = new a[] { iKF, iKG, iKH, iKI, iKJ, iKK, iKL, iKM, iKN, iKO, iKP, iKQ };
    AppMethodBeat.o(132829);
  }
  
  private AppBrandRemoteTaskController$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.a
 * JD-Core Version:    0.7.0.1
 */