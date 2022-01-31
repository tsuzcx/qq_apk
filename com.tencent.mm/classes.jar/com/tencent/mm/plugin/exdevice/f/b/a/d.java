package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cl;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends cl
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(19488);
    c.a locala = new c.a();
    locala.yrK = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "rankID";
    locala.yrM.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "appusername";
    locala.yrM.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.yrM.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "ranknum";
    locala.yrM.put("ranknum", "INTEGER");
    localStringBuilder.append(" ranknum INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "score";
    locala.yrM.put("score", "INTEGER");
    localStringBuilder.append(" score INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "likecount";
    locala.yrM.put("likecount", "INTEGER default '0' ");
    localStringBuilder.append(" likecount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "selfLikeState";
    locala.yrM.put("selfLikeState", "INTEGER default '3' ");
    localStringBuilder.append(" selfLikeState INTEGER default '3' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(19488);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(19487);
    String str = "{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score;
    str = str + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState;
    str = str + "}";
    AppMethodBeat.o(19487);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.b.a.d
 * JD-Core Version:    0.7.0.1
 */