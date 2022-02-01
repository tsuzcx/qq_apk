package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class d$1
  extends HashMap<Integer, String>
{
  d$1()
  {
    AppMethodBeat.i(24775);
    put(Integer.valueOf(-1), "CONNECT_STATE_NOT_CONNECT");
    put(Integer.valueOf(0), "CONNECT_STATE_NOT_WECHAT_WIFI");
    put(Integer.valueOf(1), "CONNECT_STATE_CONNECTING");
    put(Integer.valueOf(2), "CONNECT_STATE_CONNECT_SUCCESS");
    put(Integer.valueOf(3), "CONNECT_STATE_CONNECT_FAILED");
    put(Integer.valueOf(4), "CONNECT_STATE_WAIT_START");
    AppMethodBeat.o(24775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.d.1
 * JD-Core Version:    0.7.0.1
 */