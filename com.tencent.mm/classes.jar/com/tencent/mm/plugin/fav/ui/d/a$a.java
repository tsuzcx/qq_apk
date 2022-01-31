package com.tencent.mm.plugin.fav.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import java.util.Map;

public final class a$a
{
  public String ejd;
  public boolean jTS;
  public long lastUpdateTime;
  public a.c mCU;
  public boolean mzp;
  public Map<Long, g> mzq;
  public boolean mzx;
  
  public final String toString()
  {
    AppMethodBeat.i(74614);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
    ((StringBuilder)localObject).append("isSearching:").append(this.jTS).append('\n');
    ((StringBuilder)localObject).append("search str:").append(this.ejd).append('\n');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(74614);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a.a
 * JD-Core Version:    0.7.0.1
 */