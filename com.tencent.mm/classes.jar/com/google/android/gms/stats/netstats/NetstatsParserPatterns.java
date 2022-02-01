package com.google.android.gms.stats.netstats;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.stats.internal.G.netStats.patterns;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetstatsParserPatterns
{
  public static final String BUCKET_PATTERN;
  public static final String HISTORY_PATTERN = ".*bucketDuration=(?<duration>[0-9]+).*";
  public static final String IDENTS_PATTERN = " *ident=\\[(?<idents>.*)\\](?: uid=(?<uid>-?[0-9]+))?(?: set=(?<set>\\w+))?(?: tag=0x(?<tag>[0-9a-f]+))?.*";
  public static final String IDENT_PATTERN;
  public static final String NEW_BUCKET_PATTERN = " *st=(?<start>[0-9]+)(?: rb=(?<rxBytes>[0-9]+))?(?: rp=(?<rxPackets>[0-9]+))?(?: tb=(?<txBytes>[0-9]+))?(?: tp=(?<txPackets>[0-9]+))?(?: op=(?<operations>[0-9]+))?.*";
  public static final String NEW_IDENT_PATTERN = "[\\[{](?:type=(?<type>-1|\\w+))[, ]*(?:subType=(?<subtype>[^,]+))?[, ]*(?:subscriberId=(?<subscriberId>[0-9]+)(?:...)?)?[, ]*(?<roaming>ROAMING)?[^\\]}]*[\\]}]";
  public static final int NEW_TS_TO_MILLIS = 1000;
  public static final String OLD_BUCKET_PATTERN = " *bucketStart=(?<start>[0-9]+)(?: activeTime=(?<active>[0-9]+))?(?: rxBytes=(?<rxBytes>[0-9]+))?(?: rxPackets=(?<rxPackets>[0-9]+))?(?: txBytes=(?<txBytes>[0-9]+))?(?: txPackets=(?<txPackets>[0-9]+))?(?: operations=(?<operations>[0-9]+))?.*";
  public static final String OLD_IDENT_PATTERN = "\\[(?:type=(?<type>-1|\\w+))[, ]*(?:subType=(?<subtype>[^,]+))?[, ]*(?:subscriberId=(?<subscriberId>[0-9]+)(?:...)?)?[, ]*(?<roaming>ROAMING)?[^]]*\\]";
  public static final int OLD_TS_TO_MILLIS = 1;
  public static final int TS_TO_MILLIS;
  public static final String TYPE_BACKGROUND_PATTERN = "DEFAULT";
  public static final String TYPE_BOTH_PATTERN = "ALL";
  public static final String TYPE_DEBUG_VPN_IN_PATTERN = "DBG_VPN_IN";
  public static final String TYPE_DEBUG_VPN_OUT_PATTERN = "DBG_VPN_OUT";
  public static final String TYPE_FOREGROUND_PATTERN = "FOREGROUND";
  public static final String UID_STATS_START_PATTERN = "UID stats:|Detailed UID stats:";
  public static final String UID_TAG_STATS_START_PATTERN = "UID tag stats:";
  private static final Pattern zzafe;
  private Pattern zzaen;
  private Map<String, Integer> zzaeo;
  private Pattern zzaep;
  private Map<String, Integer> zzaeq;
  private Pattern zzaer;
  private Map<String, Integer> zzaes;
  private Pattern zzaet;
  private Map<String, Integer> zzaeu;
  private Pattern zzaev;
  private Pattern zzaew;
  private Pattern zzaex;
  private Pattern zzaey;
  private Pattern zzaez;
  private Pattern zzafa;
  private Pattern zzafb;
  private int zzafc;
  private int zzafd;
  
  static
  {
    AppMethodBeat.i(73492);
    String str;
    if (PlatformVersion.isAtLeastLollipopMR1())
    {
      str = "[\\[{](?:type=(?<type>-1|\\w+))[, ]*(?:subType=(?<subtype>[^,]+))?[, ]*(?:subscriberId=(?<subscriberId>[0-9]+)(?:...)?)?[, ]*(?<roaming>ROAMING)?[^\\]}]*[\\]}]";
      IDENT_PATTERN = str;
      if (!PlatformVersion.isAtLeastLollipopMR1()) {
        break label65;
      }
      str = " *st=(?<start>[0-9]+)(?: rb=(?<rxBytes>[0-9]+))?(?: rp=(?<rxPackets>[0-9]+))?(?: tb=(?<txBytes>[0-9]+))?(?: tp=(?<txPackets>[0-9]+))?(?: op=(?<operations>[0-9]+))?.*";
      label27:
      BUCKET_PATTERN = str;
      if (!PlatformVersion.isAtLeastLollipopMR1()) {
        break label71;
      }
    }
    label65:
    label71:
    for (int i = 1000;; i = 1)
    {
      TS_TO_MILLIS = i;
      zzafe = Pattern.compile("\\?<([a-zA-Z0-9]+)>");
      AppMethodBeat.o(73492);
      return;
      str = "\\[(?:type=(?<type>-1|\\w+))[, ]*(?:subType=(?<subtype>[^,]+))?[, ]*(?:subscriberId=(?<subscriberId>[0-9]+)(?:...)?)?[, ]*(?<roaming>ROAMING)?[^]]*\\]";
      break;
      str = " *bucketStart=(?<start>[0-9]+)(?: activeTime=(?<active>[0-9]+))?(?: rxBytes=(?<rxBytes>[0-9]+))?(?: rxPackets=(?<rxPackets>[0-9]+))?(?: txBytes=(?<txBytes>[0-9]+))?(?: txPackets=(?<txPackets>[0-9]+))?(?: operations=(?<operations>[0-9]+))?.*";
      break label27;
    }
  }
  
  public NetstatsParserPatterns()
  {
    AppMethodBeat.i(73479);
    String str = (String)G.netStats.patterns.IDENTS.getBinderSafe();
    this.zzaen = zzp(str);
    this.zzaeo = zzo(str);
    str = (String)G.netStats.patterns.IDENT.getBinderSafe();
    this.zzaep = zzp(str);
    this.zzaeq = zzo(str);
    str = (String)G.netStats.patterns.HISTORY.getBinderSafe();
    this.zzaer = zzp(str);
    this.zzaes = zzo(str);
    str = (String)G.netStats.patterns.BUCKET.getBinderSafe();
    this.zzaet = zzp(str);
    this.zzaeu = zzo(str);
    this.zzaev = Pattern.compile((String)G.netStats.patterns.UID_STATS_START.getBinderSafe());
    this.zzaew = Pattern.compile((String)G.netStats.patterns.UID_TAG_STATS_START.getBinderSafe());
    this.zzaex = Pattern.compile((String)G.netStats.patterns.TYPE_BOTH.getBinderSafe());
    this.zzaey = Pattern.compile((String)G.netStats.patterns.TYPE_BACKGROUND.getBinderSafe());
    this.zzaez = Pattern.compile((String)G.netStats.patterns.TYPE_FOREGROUND.getBinderSafe());
    this.zzafa = Pattern.compile((String)G.netStats.patterns.TYPE_DEBUG_VPN_IN_PATTERN.getBinderSafe());
    this.zzafb = Pattern.compile((String)G.netStats.patterns.TYPE_DEBUG_VPN_OUT_PATTERN.getBinderSafe());
    this.zzafc = ((Integer)G.netStats.patterns.TAG_RADIX.getBinderSafe()).intValue();
    this.zzafd = ((Integer)G.netStats.patterns.TS_TO_MILLIS.getBinderSafe()).intValue();
    AppMethodBeat.o(73479);
  }
  
  private static Map<String, Integer> zzo(String paramString)
  {
    AppMethodBeat.i(73480);
    HashMap localHashMap = new HashMap();
    paramString = zzafe.matcher(paramString);
    int i = 1;
    while (paramString.find())
    {
      localHashMap.put(paramString.group(1), Integer.valueOf(i));
      i += 1;
    }
    AppMethodBeat.o(73480);
    return localHashMap;
  }
  
  private static Pattern zzp(String paramString)
  {
    AppMethodBeat.i(73481);
    paramString = Pattern.compile(zzafe.matcher(paramString).replaceAll(""));
    AppMethodBeat.o(73481);
    return paramString;
  }
  
  public NetstatsParserPatterns.NetstatsMatcher bucket(String paramString)
  {
    AppMethodBeat.i(73485);
    paramString = new NetstatsParserPatterns.NetstatsMatcher(this.zzaet.matcher(paramString), this.zzaeu);
    AppMethodBeat.o(73485);
    return paramString;
  }
  
  public NetstatsParserPatterns.NetstatsMatcher history(String paramString)
  {
    AppMethodBeat.i(73484);
    paramString = new NetstatsParserPatterns.NetstatsMatcher(this.zzaer.matcher(paramString), this.zzaes);
    AppMethodBeat.o(73484);
    return paramString;
  }
  
  public NetstatsParserPatterns.NetstatsMatcher ident(String paramString)
  {
    AppMethodBeat.i(73483);
    paramString = new NetstatsParserPatterns.NetstatsMatcher(this.zzaep.matcher(paramString), this.zzaeq);
    AppMethodBeat.o(73483);
    return paramString;
  }
  
  public NetstatsParserPatterns.NetstatsMatcher idents(String paramString)
  {
    AppMethodBeat.i(73482);
    paramString = new NetstatsParserPatterns.NetstatsMatcher(this.zzaen.matcher(paramString), this.zzaeo);
    AppMethodBeat.o(73482);
    return paramString;
  }
  
  public boolean isTypeBackground(String paramString)
  {
    AppMethodBeat.i(73489);
    boolean bool = this.zzaey.matcher(paramString).matches();
    AppMethodBeat.o(73489);
    return bool;
  }
  
  public boolean isTypeBoth(String paramString)
  {
    AppMethodBeat.i(73488);
    boolean bool = this.zzaex.matcher(paramString).matches();
    AppMethodBeat.o(73488);
    return bool;
  }
  
  public boolean isTypeDebugVpn(String paramString)
  {
    AppMethodBeat.i(73491);
    if ((this.zzafa.matcher(paramString).matches()) || (this.zzafb.matcher(paramString).matches()))
    {
      AppMethodBeat.o(73491);
      return true;
    }
    AppMethodBeat.o(73491);
    return false;
  }
  
  public boolean isTypeForeground(String paramString)
  {
    AppMethodBeat.i(73490);
    boolean bool = this.zzaez.matcher(paramString).matches();
    AppMethodBeat.o(73490);
    return bool;
  }
  
  public boolean isUidStart(String paramString)
  {
    AppMethodBeat.i(73486);
    boolean bool = this.zzaev.matcher(paramString).matches();
    AppMethodBeat.o(73486);
    return bool;
  }
  
  public boolean isUidTagStart(String paramString)
  {
    AppMethodBeat.i(73487);
    boolean bool = this.zzaew.matcher(paramString).matches();
    AppMethodBeat.o(73487);
    return bool;
  }
  
  public int tagRadix()
  {
    return this.zzafc;
  }
  
  public long toMillis(long paramLong)
  {
    return this.zzafd * paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.stats.netstats.NetstatsParserPatterns
 * JD-Core Version:    0.7.0.1
 */