package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/LiveCoreConstants;", "", "()V", "AudienceMode", "LiveCoreEvent", "NetStatus", "plugin-core_release"})
public final class c
{
  public static final c qwp;
  
  static
  {
    AppMethodBeat.i(205595);
    qwp = new c();
    AppMethodBeat.o(205595);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/LiveCoreConstants$AudienceMode;", "", "()V", "CDN_MODE", "", "getCDN_MODE", "()I", "TRTC_MODE", "getTRTC_MODE", "plugin-core_release"})
  public static final class a
  {
    private static final int qwD = 0;
    private static final int qwR = 1;
    public static final a qxl;
    
    static
    {
      AppMethodBeat.i(205592);
      qxl = new a();
      qwR = 1;
      AppMethodBeat.o(205592);
    }
    
    public static int clK()
    {
      return qwD;
    }
    
    public static int clO()
    {
      return qwR;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/LiveCoreConstants$LiveCoreEvent;", "", "()V", "EVENT_ERR_CODE", "", "getEVENT_ERR_CODE", "()I", "EVENT_EXIT_ROOM_ERR", "getEVENT_EXIT_ROOM_ERR", "EVENT_NET_STATUS", "getEVENT_NET_STATUS", "EVENT_RENDER_FIRST_I_FRAME", "getEVENT_RENDER_FIRST_I_FRAME", "EVENT_ROOM_USER_AUDIO_STATE", "getEVENT_ROOM_USER_AUDIO_STATE", "EVENT_ROOM_USER_EXIT", "getEVENT_ROOM_USER_EXIT", "EVENT_USER_VIDEO_AVAILABLE", "getEVENT_USER_VIDEO_AVAILABLE", "EVENT_USER_VIDEO_DISABLE", "getEVENT_USER_VIDEO_DISABLE", "plugin-core_release"})
  public static final class b
  {
    private static final int qxM = 1;
    private static final int qxN = 2;
    private static final int qxO = 3;
    private static final int qxV = 4;
    private static final int qxw = 0;
    private static final int qyb = 5;
    private static final int qyc = 6;
    private static final int qyd = 7;
    public static final b qye;
    
    static
    {
      AppMethodBeat.i(205593);
      qye = new b();
      qxM = 1;
      qxN = 2;
      qxO = 3;
      qxV = 4;
      qyb = 5;
      qyc = 6;
      qyd = 7;
      AppMethodBeat.o(205593);
    }
    
    public static int clQ()
    {
      return qxw;
    }
    
    public static int clR()
    {
      return qxM;
    }
    
    public static int clS()
    {
      return qxN;
    }
    
    public static int cmb()
    {
      return qxO;
    }
    
    public static int cml()
    {
      return qxV;
    }
    
    public static int cmv()
    {
      return qyb;
    }
    
    public static int cmw()
    {
      return qyc;
    }
    
    public static int cmy()
    {
      return qyd;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/LiveCoreConstants$NetStatus;", "", "()V", "NET_BAD", "", "getNET_BAD", "()I", "NET_DISABLE", "getNET_DISABLE", "NET_GOOD", "getNET_GOOD", "NET_NORMAL", "getNET_NORMAL", "plugin-core_release"})
  public static final class c
  {
    private static final int qyf = 0;
    private static final int qyg = 1;
    private static final int qyh = 2;
    private static final int qyi = 3;
    public static final c qyj;
    
    static
    {
      AppMethodBeat.i(205594);
      qyj = new c();
      qyg = 1;
      qyh = 2;
      qyi = 3;
      AppMethodBeat.o(205594);
    }
    
    public static int cmA()
    {
      return qyf;
    }
    
    public static int cmG()
    {
      return qyg;
    }
    
    public static int cnl()
    {
      return qyh;
    }
    
    public static int cnp()
    {
      return qyi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c
 * JD-Core Version:    0.7.0.1
 */