package com.tencent.mm.plugin.cast.h.b;

import java.net.Socket;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/transportclient/reader/RemoteReaderImp;", "", "addHandlers", "", "handlers", "", "Lcom/tencent/mm/plugin/cast/transportclient/reader/handlers/HandlerImp;", "createReader", "socket", "Ljava/net/Socket;", "destroyReader", "plugin-cast_release"})
public abstract interface b
{
  public abstract void c(Socket paramSocket);
  
  public abstract void cLU();
  
  public abstract void cX(List<? extends Object> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.h.b.b
 * JD-Core Version:    0.7.0.1
 */