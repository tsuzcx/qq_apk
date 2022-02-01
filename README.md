# qq_apk
备份旧版本 qq 安装包，以备查询

分支 pr_holder 用于接收和合并 pull request

- 因为该仓库的目的在于记录各个版本 apk 的内容，并比较他们的变化
- 因此 main 分支中的代码将保持原始状态

## QQ：com.tencent.mobileqq

| 版本  | 修改日期  |
| ----- | --------- |
| 7.6.0 | 2018-05-05 11:03:26 |
| 7.6.3_1 | 2018-05-25 14:46:56 |
| 7.6.3_2 | 2018-06-01 10:06:56 |
| 7.6.8 | 2018-06-27 12:50:42 |
| 8.2.6 | 2020-01-02 22:40:52 |
| 8.2.8 | 2020-02-27 20:01:22 |
| 8.3.0 | 2020-03-16 15:14:52 |
| 8.3.3 | 2020-04-16 03:14:42 |
| 8.3.5 | 2020-04-27 19:56:40 |
| 8.4.1 | 2020-07-14 21:34:02 |
| 8.4.5 | 2020-08-13 15:52:14 |
| 8.4.8 | 2020-09-10 00:58:42 |
| 8.4.10 | 2020-10-20 23:20:28 |
| 8.5.5 | 2021-01-15 02:07:30 |
| 8.7.0 | 2021-04-27 21:41:54 |
| 8.8.17 | 2021-08-04 01:49:18 |
| 8.8.68 | 2022-01-21 15:10:10 |

### 2018.5 QQ脏话门事件

- 在QQ中发送菜刀、爱心等表情与字符的组合，就会被替换为脏话，并且是发出后才发生替换，因此在发消息之前发送者并不知情，而发出后接收者就直接看到脏话，引起聊天中的误会
- 2018.5.28 晚上官方在线修复问题，该替换逐渐无效
  - 也就是说，腾讯具备在线控制模块是否运行的能力

相关文件：

- [com.tencent.mobileqq/classes.jar/com/tencent/mobileqq/lovelanguage](https://github.com/tsuzcx/qq_apk/tree/d2564324b925d30b364748ec005c8ae9c4c7ef81/com.tencent.mobileqq/classes.jar/com/tencent/mobileqq/lovelanguage)
- 目前已经不存在

版本对比结果：

- 早在 5.5 的 7.6.0 版本中就已经存在
  - [LoveLanguageConfig.java](https://github.com/tsuzcx/qq_apk/blob/39540a850bbb8228cbbe6644d985da0652695df2/com.tencent.mobileqq/classes.jar/com/tencent/mobileqq/lovelanguage/LoveLanguageConfig.java) 中的 jdField_a_of_type_ArrayOfJavaLangString 字段包含了脏话字符串
- 5.25 的 7.6.3 版本中，修改了 jdField_a_of_type_ArrayOfInt 数组
- 6.1 在发现问题后，[删除了2个函数的主要内容](https://github.com/tsuzcx/qq_apk/blame/3dd1a120029f2cbcc7ede09dd3fa1e214df0a3e0/com.tencent.mobileqq/classes.jar/com/tencent/mobileqq/lovelanguage/LoveLanguageManager.java)
- 6.27 的 7.6.8 版本中删除了大部分函数的主要内容，[但脏话数组依然原封不动地保留在原地](https://github.com/tsuzcx/qq_apk/blame/52d8956055474225051d6eb45a6a4c6a515b9b4b/com.tencent.mobileqq/classes.jar/com/tencent/mobileqq/lovelanguage/LoveLanguageConfig.java)，看起来像是故意留下的
- 此后的 8.2.6 版本中已经没有 lovelanguage 这个文件夹

部分 github 上搜索到的相关分析：

- 已经有很多大佬对这个事情进行了详细的分析，这里我就只记录代码，不深入分析了，具体详细原理可以参考他们的文章
- [QQ 发送菜刀加符号导致脏话的真实原因分析](https://github.com/pingfangx/BlogX/blob/master/essay/draft/android/crack/%5B2538%5DQQ%20%E5%8F%91%E9%80%81%E8%8F%9C%E5%88%80%E5%8A%A0%E7%AC%A6%E5%8F%B7%E5%AF%BC%E8%87%B4%E8%84%8F%E8%AF%9D%E7%9A%84%E7%9C%9F%E5%AE%9E%E5%8E%9F%E5%9B%A0%E5%88%86%E6%9E%90.md)
- [QQ表情-脏话bug漏洞](https://skylinelulu.github.io/2018/09/02/QQEmojiBug/)

### 8.8.68 反编译失败

Apktool 报错。命令行输出：

```
I: Using Apktool 2.6.0 on QQ-8.8.68-2538-3834.apk
I: Loading resource table...
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.qqguild_df_impl), pkgId: 112
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.qqguild_df_impl), pkgId: 112
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.qqmini_impl), pkgId: 121
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.qqguild_df_impl), pkgId: 112
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.qqnearby_impl), pkgId: 115
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.qqmini_impl), pkgId: 121
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.qqguild_df_impl), pkgId: 112
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.qqnearby_impl), pkgId: 115
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.qqmini_impl), pkgId: 121
I: Decoding Shared Library (com.tencent.mobileqq.qqpay_temp_impl), pkgId: 122
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.qqguild_df_impl), pkgId: 112
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.qqnearby_impl), pkgId: 115
I: Decoding Shared Library (com.tencent.mobileqq.qqpubaccount_impl), pkgId: 116
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.qqmini_impl), pkgId: 121
I: Decoding Shared Library (com.tencent.mobileqq.qqpay_temp_impl), pkgId: 122
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.qqguild_df_impl), pkgId: 112
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.qqnearby_impl), pkgId: 115
I: Decoding Shared Library (com.tencent.mobileqq.qqpubaccount_impl), pkgId: 116
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.qqrtc_feature_impl), pkgId: 120
I: Decoding Shared Library (com.tencent.mobileqq.qqmini_impl), pkgId: 121
I: Decoding Shared Library (com.tencent.mobileqq.qqpay_temp_impl), pkgId: 122
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.qqguild_df_impl), pkgId: 112
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.qqweishi_impl), pkgId: 114
I: Decoding Shared Library (com.tencent.mobileqq.qqnearby_impl), pkgId: 115
I: Decoding Shared Library (com.tencent.mobileqq.qqpubaccount_impl), pkgId: 116
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.qqrtc_feature_impl), pkgId: 120
I: Decoding Shared Library (com.tencent.mobileqq.qqmini_impl), pkgId: 121
I: Decoding Shared Library (com.tencent.mobileqq.qqpay_temp_impl), pkgId: 122
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
I: Decoding Shared Library (com.tencent.mobileqq.matchfriend_impl), pkgId: 109
I: Decoding Shared Library (com.tencent.mobileqq.profilecard_feature_impl), pkgId: 110
I: Decoding Shared Library (com.tencent.mobileqq.wxmini_impl), pkgId: 111
I: Decoding Shared Library (com.tencent.mobileqq.qqguild_df_impl), pkgId: 112
I: Decoding Shared Library (com.tencent.mobileqq.qqexpand_impl), pkgId: 113
I: Decoding Shared Library (com.tencent.mobileqq.qqweishi_impl), pkgId: 114
I: Decoding Shared Library (com.tencent.mobileqq.qqnearby_impl), pkgId: 115
I: Decoding Shared Library (com.tencent.mobileqq.qqpubaccount_impl), pkgId: 116
I: Decoding Shared Library (com.tencent.mobileqq.cmshow_impl), pkgId: 118
I: Decoding Shared Library (com.tencent.mobileqq.qq_comic_impl), pkgId: 119
I: Decoding Shared Library (com.tencent.mobileqq.qqrtc_feature_impl), pkgId: 120
I: Decoding Shared Library (com.tencent.mobileqq.qqmini_impl), pkgId: 121
I: Decoding Shared Library (com.tencent.mobileqq.qqpay_temp_impl), pkgId: 122
I: Decoding Shared Library (com.tencent.mobileqq.aelight_impl), pkgId: 123
I: Decoding Shared Library (com.tencent.mobileqq.qq_qzonehub_impl), pkgId: 124
I: Decoding Shared Library (com.tencent.mobileqq.kandian_feature_impl), pkgId: 125
I: Decoding Shared Library (com.tencent.mobileqq.kandian_ad_feature_impl), pkgId: 126
Exception in thread "main" java.lang.IllegalArgumentException: Chunk [ text-decoration:none] is not a valid entry
        at com.google.common.base.Preconditions.checkArgument(Preconditions.java:219)
        at com.google.common.base.Splitter$MapSplitter.split(Splitter.java:526)
        at brut.androlib.res.decoder.StringBlock$Tag.toString(StringBlock.java:167)
        at java.lang.String.valueOf(String.java:2994)
        at java.lang.StringBuilder.append(StringBuilder.java:131)
        at brut.androlib.res.decoder.StringBlock.processStyledString(StringBlock.java:260)
        at brut.androlib.res.decoder.StringBlock.getHTML(StringBlock.java:288)
        at brut.androlib.res.decoder.ARSCDecoder.readValue(ARSCDecoder.java:366)
        at brut.androlib.res.decoder.ARSCDecoder.readEntryData(ARSCDecoder.java:285)
        at brut.androlib.res.decoder.ARSCDecoder.readTableType(ARSCDecoder.java:261)
        at brut.androlib.res.decoder.ARSCDecoder.readTableTypeSpec(ARSCDecoder.java:184)
        at brut.androlib.res.decoder.ARSCDecoder.readTablePackage(ARSCDecoder.java:135)
        at brut.androlib.res.decoder.ARSCDecoder.readTableHeader(ARSCDecoder.java:84)
        at brut.androlib.res.decoder.ARSCDecoder.decode(ARSCDecoder.java:50)
        at brut.androlib.res.AndrolibResources.getResPackagesFromApk(AndrolibResources.java:783)
        at brut.androlib.res.AndrolibResources.loadMainPkg(AndrolibResources.java:64)
        at brut.androlib.res.AndrolibResources.getResTable(AndrolibResources.java:56)
        at brut.androlib.Androlib.getResTable(Androlib.java:69)
        at brut.androlib.ApkDecoder.getResTable(ApkDecoder.java:247)
        at brut.androlib.ApkDecoder.decode(ApkDecoder.java:109)
        at brut.apktool.Main.cmdDecode(Main.java:175)
        at brut.apktool.Main.main(Main.java:78)
```

## QQ国际版：com.tencent.mobileqqi

| 版本  | 修改日期  |
| ----- | --------- |
| 6.0.0 | 2018-05-20 17:50:16 |
| 6.0.1 | 2018-09-27 01:37:52 |
| 6.0.2 | 2020-04-24 15:30:20 |
| 6.0.3 | 2020-06-24 19:53:48 |

## QQ轻聊版：com.tencent.qqlite

| 版本  | 修改日期  |
| ----- | --------- |
| 3.3.0 | 2015-07-08 10:35:48 |
| 3.4.0 | 2015-11-16 18:15:42 |
| 3.5.0 | 2016-06-24 16:08:08 |

## QQ-HD：com.tencent.minihd.qq

| 版本  | 修改日期  |
| ----- | --------- |
| 5.9.3 | 2021-11-21 02:06:06 |

## TIM：com.tencent.tim

| 版本  | 修改日期  |
| ----- | --------- |
| 3.4.4 | 2021-11-22 17:33:36 |

## 微信：com.tencent.mm

| 版本  | 修改日期  |
| ----- | --------- |
| 6.7.3 | 2018-09-28 16:43:38 |
| 7.0.5 | 2019-07-05 15:51:06 |
| 7.0.15 | 2020-06-01 13:44:34 |
| 7.0.16 | 2020-06-24 21:00:54 |
| 7.0.18 | 2020-08-19 21:43:34 |
| 7.0.19 | 2020-09-16 22:16:52 |
| 8.0.0 | 2021-01-25 16:51:00 |
| 8.0.7 | 2021-07-02 19:49:30 |
| 8.0.19 | 2022-01-25 19:30:20 |

## QQ安全中心：com.tencent.token

| 版本  | 修改日期  |
| ----- | --------- |
| 6.7.2 | 2016-05-19 17:06:48 |
| 6.9.15 | 2019-12-23 17:16:22 |
| 6.9.16 | 早于 2020-09-22 |
| 6.9.17 | 早于 2020-09-22 |
| 6.9.18 | 2020-09-22 20:25:24 |
| 6.9.19 | 早于 2021-04-07 |
| 6.9.20 | 早于 2021-04-07 |
| 6.9.21 | 早于 2021-06-26 |
| 6.9.22_1 | 早于 2021-06-26 |
| 6.9.22_2 | 早于 2021-06-26 |
| 6.9.23 | 早于 2021-09-04 |
| 6.9.26 | 早于 2022-02-01 |

