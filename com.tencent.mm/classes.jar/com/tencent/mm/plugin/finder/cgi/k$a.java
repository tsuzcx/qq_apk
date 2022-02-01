package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.cqk;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$Callback;", "", "isBeginHistory", "", "isResultConsume", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onBuildRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderStreamRequest;", "onCgiBack", "errMsg", "", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "plugin-finder_release"})
public abstract interface k$a
{
  public abstract void a(int paramInt1, int paramInt2, String paramString, k.d paramd);
  
  public abstract void a(aod paramaod);
  
  public abstract boolean b(int paramInt1, int paramInt2, cqk paramcqk);
  
  public abstract boolean csh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k.a
 * JD-Core Version:    0.7.0.1
 */