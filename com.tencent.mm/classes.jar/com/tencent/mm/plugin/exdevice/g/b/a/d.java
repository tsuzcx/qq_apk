package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dm;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends dm
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(23556);
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "rankID";
    locala.IBN.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "appusername";
    locala.IBN.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "username";
    locala.IBN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "ranknum";
    locala.IBN.put("ranknum", "INTEGER");
    localStringBuilder.append(" ranknum INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "score";
    locala.IBN.put("score", "INTEGER");
    localStringBuilder.append(" score INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "likecount";
    locala.IBN.put("likecount", "INTEGER default '0' ");
    localStringBuilder.append(" likecount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "selfLikeState";
    locala.IBN.put("selfLikeState", "INTEGER default '3' ");
    localStringBuilder.append(" selfLikeState INTEGER default '3' ");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(23556);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(23555);
    String str = "{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score;
    str = str + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState;
    str = str + "}";
    AppMethodBeat.o(23555);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.a.d
 * JD-Core Version:    0.7.0.1
 */