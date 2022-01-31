package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class d$e
  extends AsyncTask<Object, Void, Void>
{
  d$e(d paramd) {}
  
  private Void b(Object... paramVarArgs)
  {
    int i = 0;
    List localList = (List)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    for (;;)
    {
      try
      {
        paramVarArgs = this.YG.mContext.openFileOutput(paramVarArgs, 0);
        localXmlSerializer = Xml.newSerializer();
        int j;
        d.c localc;
        localXmlSerializer.endTag(null, "historical-records");
      }
      catch (FileNotFoundException paramVarArgs)
      {
        try
        {
          localXmlSerializer.setOutput(paramVarArgs, null);
          localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
          localXmlSerializer.startTag(null, "historical-records");
          j = localList.size();
          if (i >= j) {
            break label187;
          }
          localc = (d.c)localList.remove(0);
          localXmlSerializer.startTag(null, "historical-record");
          localXmlSerializer.attribute(null, "activity", localc.YF.flattenToString());
          localXmlSerializer.attribute(null, "time", String.valueOf(localc.time));
          localXmlSerializer.attribute(null, "weight", String.valueOf(localc.weight));
          localXmlSerializer.endTag(null, "historical-record");
          i += 1;
          continue;
          paramVarArgs = paramVarArgs;
          paramVarArgs = d.LT;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          XmlSerializer localXmlSerializer;
          String str1 = d.LT;
          new StringBuilder("Error writing historical record file: ").append(this.YG.Yx);
          this.YG.YA = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          String str2 = d.LT;
          new StringBuilder("Error writing historical record file: ").append(this.YG.Yx);
          this.YG.YA = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        catch (IOException localIOException)
        {
          String str3 = d.LT;
          new StringBuilder("Error writing historical record file: ").append(this.YG.Yx);
          this.YG.YA = true;
          if (paramVarArgs == null) {
            continue;
          }
          try
          {
            paramVarArgs.close();
            return null;
          }
          catch (IOException paramVarArgs)
          {
            return null;
          }
        }
        finally
        {
          this.YG.YA = true;
          if (paramVarArgs == null) {
            break label388;
          }
        }
        return null;
      }
      label187:
      localXmlSerializer.endDocument();
      this.YG.YA = true;
      if (paramVarArgs != null) {
        try
        {
          paramVarArgs.close();
          return null;
        }
        catch (IOException paramVarArgs)
        {
          return null;
        }
      }
    }
    try
    {
      paramVarArgs.close();
      label388:
      throw localObject;
    }
    catch (IOException paramVarArgs)
    {
      break label388;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.d.e
 * JD-Core Version:    0.7.0.1
 */