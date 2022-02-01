package com.tencent.mm.plugin.cast.g.b;

import java.net.Socket;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/transportclient/reader/RemoteReaderImp;", "", "addHandlers", "", "handlers", "", "Lcom/tencent/mm/plugin/cast/transportclient/reader/handlers/HandlerImp;", "createReader", "socket", "Ljava/net/Socket;", "destroyReader", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void c(Socket paramSocket);
  
  public abstract void dpA();
  
  public abstract void eS(List<? extends Object> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.g.b.b
 * JD-Core Version:    0.7.0.1
 */