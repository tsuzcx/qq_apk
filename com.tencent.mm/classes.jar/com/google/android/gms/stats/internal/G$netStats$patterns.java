package com.google.android.gms.stats.internal;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.stats.netstats.NetstatsParserPatterns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class G$netStats$patterns
{
  public static final GservicesValue<String> BUCKET;
  public static final GservicesValue<String> HISTORY;
  public static final GservicesValue<String> IDENT;
  public static final GservicesValue<String> IDENTS;
  public static final GservicesValue<Integer> TAG_RADIX;
  public static final GservicesValue<Integer> TS_TO_MILLIS;
  public static final GservicesValue<String> TYPE_BACKGROUND;
  public static final GservicesValue<String> TYPE_BOTH;
  public static final GservicesValue<String> TYPE_DEBUG_VPN_IN_PATTERN;
  public static final GservicesValue<String> TYPE_DEBUG_VPN_OUT_PATTERN;
  public static final GservicesValue<String> TYPE_FOREGROUND;
  public static final GservicesValue<String> UID_STATS_START;
  public static final GservicesValue<String> UID_TAG_STATS_START;
  
  static
  {
    AppMethodBeat.i(73474);
    IDENTS = GservicesValue.value("gms:stats:netstats:pattern:idents", " *ident=\\[(?<idents>.*)\\](?: uid=(?<uid>-?[0-9]+))?(?: set=(?<set>\\w+))?(?: tag=0x(?<tag>[0-9a-f]+))?.*");
    IDENT = GservicesValue.value("gms:stats:netstats:pattern:ident", NetstatsParserPatterns.IDENT_PATTERN);
    HISTORY = GservicesValue.value("gms:stats:netstats:pattern:history", ".*bucketDuration=(?<duration>[0-9]+).*");
    BUCKET = GservicesValue.value("gms:stats:netstats:pattern:bucket", NetstatsParserPatterns.BUCKET_PATTERN);
    UID_STATS_START = GservicesValue.value("gms:stats:netstats:pattern:uid_start", "UID stats:|Detailed UID stats:");
    UID_TAG_STATS_START = GservicesValue.value("gms:stats:netstats:pattern:uid_tag_start", "UID tag stats:");
    TYPE_BOTH = GservicesValue.value("gms:stats:netstats:pattern:type_both", "ALL");
    TYPE_BACKGROUND = GservicesValue.value("gms:stats:netstats:pattern:type_background", "DEFAULT");
    TYPE_FOREGROUND = GservicesValue.value("gms:stats:netstats:pattern:type_foreground", "FOREGROUND");
    TYPE_DEBUG_VPN_IN_PATTERN = GservicesValue.value("gms:stats:netstats:pattern:type_debug_vpn_in_pattern", "DBG_VPN_IN");
    TYPE_DEBUG_VPN_OUT_PATTERN = GservicesValue.value("gms:stats:netstats:pattern:type_debug_vpn_out_pattern", "DBG_VPN_OUT");
    TAG_RADIX = GservicesValue.value("gms:stats:netstats:pattern:tag_radix", Integer.valueOf(16));
    TS_TO_MILLIS = GservicesValue.value("gms:stats:netstats:pattern:ts_to_millis", Integer.valueOf(NetstatsParserPatterns.TS_TO_MILLIS));
    AppMethodBeat.o(73474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.stats.internal.G.netStats.patterns
 * JD-Core Version:    0.7.0.1
 */